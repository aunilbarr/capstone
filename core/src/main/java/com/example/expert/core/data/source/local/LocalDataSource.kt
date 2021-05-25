package com.example.expert.core.data.source.local

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalDataSource(private val Dao: com.example.expert.core.data.source.local.room.MovieDao) {
    fun getFavorite() = Dao.getFavorite()

    fun check(
        id: Int,
        callback: com.example.expert.core.data.source.local.LocalDataSource.CheckFavoriteCallback
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            callback.onChecked(Dao.check(id))
        }
    }

    fun insert(Entity: com.example.expert.core.data.source.local.entity.movie) {
        CoroutineScope(Dispatchers.IO).launch {
            Dao.insert(Entity)
        }
    }

    fun delete(Entity: com.example.expert.core.data.source.local.entity.movie) {
        CoroutineScope(Dispatchers.IO).launch {
            Dao.delete(Entity)
        }
    }

    interface CheckFavoriteCallback {
        fun onChecked(Entity: com.example.expert.core.data.source.local.entity.id?)
    }
}