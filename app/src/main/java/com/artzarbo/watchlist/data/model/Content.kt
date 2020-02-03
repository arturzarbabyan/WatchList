package com.artzarbo.watchlist.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "items_table")
data class Content(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id:Int,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "section") val section:String,
    @ColumnInfo(name = "isWatched") val isWatched:Boolean,
    @ColumnInfo(name = "url") val url:String,
    @ColumnInfo(name = "releaseDate") val releaseDate:String,
    @ColumnInfo(name = "genres") val genres:String){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val data = other as Content
        return  id == data.id &&
                title == data.title &&
                section == data.section &&
                url == data.url &&
                releaseDate == data.releaseDate
    }

    override fun hashCode(): Int {
        return Objects.hash(id,title,section,isWatched,url,releaseDate,genres)
    }
}