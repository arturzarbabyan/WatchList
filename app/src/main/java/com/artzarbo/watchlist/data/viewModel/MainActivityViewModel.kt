package com.artzarbo.watchlist.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.artzarbo.watchlist.data.Repository
import com.artzarbo.watchlist.data.model.Content

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = Repository.getInstance(application)
    private val content: LiveData<PagedList<Content>> =
        LivePagedListBuilder<Int, Content>(repository.getDao().getAll(), 20).build()

    fun getAllData(): LiveData<PagedList<Content>> = content

    fun getDataBySection(section: String): LiveData<PagedList<Content>> =
        LivePagedListBuilder<Int, Content>(
            repository.getDao().getAllBySection(section), 20
        ).build()

    fun addContent(content: Content): Boolean {
        return repository.insertData(content)
    }
}