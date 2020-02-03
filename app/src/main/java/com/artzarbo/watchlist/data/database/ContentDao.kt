package com.artzarbo.watchlist.data.database

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.artzarbo.watchlist.data.model.Content

@Dao
interface ContentDao {

    @Query("SELECT * FROM items_table")
    fun getAll():DataSource.Factory<Int,Content>

    @Query("SELECT * FROM items_table WHERE section LIKE :section")
    fun getAllBySection(section:String):DataSource.Factory<Int,Content>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(data:List<Content>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(content:Content):Long

}