package com.artzarbo.watchlist.network.interseptors

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.HttpUrl
import com.artzarbo.watchlist.utils.AppConstants



class HeaderInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("api-key", AppConstants.API_KEY)
            .build()
        return chain.proceed(request)
    }
}