package com.artzarbo.watchlist.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.artzarbo.watchlist.data.model.Content

@androidx.room.Database(entities = [Content::class],version = 1)
abstract class ContentDatabase: RoomDatabase() {
    abstract fun dao():ContentDao
    companion object{
        @Volatile private var INSTANCE:ContentDatabase? = null

        fun getDatabase(context: Context):ContentDatabase = INSTANCE?: synchronized(ContentDatabase::class){
            INSTANCE?:Room.databaseBuilder(context.applicationContext, ContentDatabase::class.java, "films_database")
                .build().also { INSTANCE = it }
        }
    }
}