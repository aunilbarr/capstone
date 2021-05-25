package com.example.expert.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [com.example.expert.core.data.source.local.entity.movie::class],
    version = 1,
    exportSchema = false
)
abstract class movieDatabase : RoomDatabase() {
    abstract fun movieDao(): com.example.expert.core.data.source.local.room.MovieDao
}