package com.artzarbo.watchlist.network.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchResponse (@SerializedName("Search") @Expose val search:List<SearchData>?,
                           @SerializedName("totalResults") @Expose val totalResults:String?,
                           @SerializedName("Response") @Expose val response:String?)