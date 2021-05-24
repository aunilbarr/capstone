package com.example.fayyadhaunilbarr.core.domain.repository

import androidx.lifecycle.LiveData
import com.example.fayyadhaunilbarr.core.domain.model.DetailModel
import com.example.fayyadhaunilbarr.core.domain.model.MovieModel
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllMovies(): Flow<List<MovieModel>>
    fun getMovieDetail(id: Int): Flow<DetailModel>
    fun getFavoriteMovies(): Flow<List<MovieModel>>
    fun checkFavoriteMovie(id: Int): LiveData<Boolean>
    fun insertMovie(movie: MovieModel)
    fun deleteMovie(movie: MovieModel)
    fun getMovieDetails(id: Int): Flow<DetailModel>
}