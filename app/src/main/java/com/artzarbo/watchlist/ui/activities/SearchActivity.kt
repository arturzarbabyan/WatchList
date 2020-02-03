package com.artzarbo.watchlist.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artzarbo.watchlist.R
import com.artzarbo.watchlist.ui.adapter.SearchAdapter

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val searchAdapter = SearchAdapter()

    }
}
