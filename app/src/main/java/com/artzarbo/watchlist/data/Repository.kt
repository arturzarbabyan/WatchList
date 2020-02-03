package com.artzarbo.watchlist.data

import android.annotation.SuppressLint
import android.content.Context
import com.artzarbo.watchlist.data.database.ContentDao
import com.artzarbo.watchlist.data.database.ContentDatabase
import com.artzarbo.watchlist.data.model.Content

class Repository private constructor(val context: Context){
    private val contentDao:ContentDao = ContentDatabase.getDatabase(context).dao()

    companion object{
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance:Repository? = null

        @JvmStatic
        fun getInstance(context: Context):Repository = instance?: synchronized(this){
            instance?:Repository(context).also { instance = it }
        }
    }

    fun insertData(content: Content):Boolean{
        val list:MutableList<Long> = ArrayList()
        val thread = Thread(Runnable {
            val insert: Long = contentDao.insert(content)
            list.add(insert)
        })
        thread.start()
        try {
            thread.join()
            return list.size>0
        }catch (e:InterruptedException){
            e.printStackTrace()
        }
        return false
    }

    fun getDao():ContentDao = contentDao


}