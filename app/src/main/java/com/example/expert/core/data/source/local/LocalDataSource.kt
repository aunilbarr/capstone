package com.example.expert.core.data.source.local

import androidx.room.Dao
import com.example.expert.core.data.source.local.entity.id
import com.example.expert.core.data.source.local.entity.movie
import com.example.expert.core.data.source.local.room.MovieDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalDataSource(private val Dao: MovieDao) {
    fun getFavorite() = Dao.getFavorite()

    fun check(id: Int, callback: CheckFavoriteCallback) {
        CoroutineScope(Dispatchers.IO).launch {
            callback.onChecked(Dao.check(id))
        }
    }

    fun insert(Entity: movie) {
        CoroutineScope(Dispatchers.IO).launch {
            Dao.insert(Entity)
        }
    }

    fun delete(Entity: movie) {
        CoroutineScope(Dispatchers.IO).launch {
            Dao.delete(Entity)
        }
    }

    interface CheckFavoriteCallback {
        fun onChecked(Entity: id?)
    }
}