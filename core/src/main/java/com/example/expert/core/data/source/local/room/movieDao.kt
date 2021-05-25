package com.example.expert.core.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(
        entity = com.example.expert.core.data.source.local.entity.movie::class,
        onConflict = OnConflictStrategy.IGNORE
    )
    fun insert(favoriteMovies: com.example.expert.core.data.source.local.entity.movie)

    @Query("SELECT * from movie_table")
    fun getFavorite(): Flow<List<com.example.expert.core.data.source.local.entity.movie>>

    @Query("SELECT * from movie_table WHERE id LIKE :searchID")
    fun check(searchID: Int): com.example.expert.core.data.source.local.entity.id?

    @Delete(entity = com.example.expert.core.data.source.local.entity.movie::class)
    fun delete(favoriteMovies: com.example.expert.core.data.source.local.entity.movie)
}