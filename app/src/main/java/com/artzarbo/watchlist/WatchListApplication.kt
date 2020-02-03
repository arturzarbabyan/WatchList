package com.artzarbo.watchlist

import android.app.Application
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import com.artzarbo.watchlist.network.interseptors.HeaderInterceptor
import okhttp3.OkHttpClient
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.artzarbo.watchlist.utils.AppConstants.BASE_URL


class WatchListApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(HeaderInterceptor())
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}