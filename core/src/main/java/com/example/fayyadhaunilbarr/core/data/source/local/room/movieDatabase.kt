package com.example.fayyadhaunilbarr.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fayyadhaunilbarr.core.data.source.local.entity.movie

@Database(entities = [com.example.fayyadhaunilbarr.core.data.source.local.entity.movie::class], version = 1, exportSchema = false)
abstract class movieDatabase : RoomDatabase() {
    abstract fun movieDao(): com.example.fayyadhaunilbarr.core.data.source.local.room.MovieDao
}