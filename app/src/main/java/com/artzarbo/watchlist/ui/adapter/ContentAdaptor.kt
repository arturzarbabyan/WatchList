package com.artzarbo.watchlist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.artzarbo.watchlist.R
import com.artzarbo.watchlist.data.model.Content

class ContentAdaptor : PagedListAdapter<Content, ContentAdaptor.ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.content_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title:TextView = view.findViewById(R.id.title)
        fun bind(content: Content) {
            title.text = content.title
        }
    }

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Content>() {
            override fun areItemsTheSame(
                oldContent: Content,
                newContent: Content
            ) = oldContent.id == newContent.id

            override fun areContentsTheSame(
                oldContent: Content,
                newContent: Content
            ) = oldContent == newContent
        }
    }
}