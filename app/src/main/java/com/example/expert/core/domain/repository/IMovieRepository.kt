package com.example.expert.core.domain.repository

import androidx.lifecycle.LiveData
import com.example.expert.Model.DetailModel
import com.example.expert.Model.MovieModel
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