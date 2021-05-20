package com.example.expert.core.data.source.local.room

import androidx.room.*
import com.example.expert.core.data.source.local.entity.id
import com.example.expert.core.data.source.local.entity.movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(entity = movie::class, onConflict = OnConflictStrategy.IGNORE)
    fun insert(favoriteMovies: movie)

    @Query("SELECT * from movie_table")
    fun getFavorite(): Flow<List<movie>>

    @Query("SELECT * from movie_table WHERE id LIKE :searchID")
    fun check(searchID: Int): id?

    @Delete(entity = movie::class)
    fun delete(favoriteMovies: movie)
}