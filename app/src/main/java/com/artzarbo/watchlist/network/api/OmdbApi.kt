package com.artzarbo.watchlist.network.api

import com.artzarbo.watchlist.network.model.request.DetailsRequest
import com.artzarbo.watchlist.network.model.request.SearchRequest
import retrofit2.http.Body
import retrofit2.http.GET

interface OmdbApi {

    @GET
    fun getSearchData(@Body searchRequest: SearchRequest)

    @GET
    fun getDetails(@Body detailsRequest: DetailsRequest)
}