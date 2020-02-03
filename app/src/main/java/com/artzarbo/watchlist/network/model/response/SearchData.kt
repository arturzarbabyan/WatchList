package com.artzarbo.watchlist.network.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class SearchData(@SerializedName("Title") @Expose val title:String?,
                 @SerializedName("Year") @Expose val year:String?,
                 @SerializedName("imdbID") @Expose val imdbID:String?,
                 @SerializedName("Type") @Expose val type:String?,
                 @SerializedName("Poster") @Expose val poster:String?){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val searchData = other as SearchData
        return title == searchData.title &&
                year == searchData.year &&
                type == searchData.type &&
                poster == searchData.poster
    }

    override fun hashCode(): Int {
        return Objects.hash(title,year,imdbID,type,poster)
    }
}
