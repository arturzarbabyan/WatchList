package com.artzarbo.watchlist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.artzarbo.watchlist.R
import com.artzarbo.watchlist.network.model.response.SearchData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class SearchAdapter : PagedListAdapter<SearchData, SearchAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.search_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val searchData = getItem(position)
        if (searchData != null) {
            holder.bind(searchData)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.title)
        private val poster: ImageView = view.findViewById(R.id.poster)

        fun bind(searchData: SearchData) {
            Glide.with(itemView.context).load(searchData.poster).apply(
                RequestOptions().placeholder(R.drawable.poster_none).error(R.drawable.poster_none)
            ).into(poster)
            title.text = searchData.title
        }

    }

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<SearchData>() {
            override fun areItemsTheSame(
                oldSearchData: SearchData,
                newSearchData: SearchData
            ) = oldSearchData.imdbID == newSearchData.imdbID

            override fun areContentsTheSame(
                oldSearchData: SearchData,
                newSearchData: SearchData
            ) = oldSearchData == newSearchData
        }
    }
}