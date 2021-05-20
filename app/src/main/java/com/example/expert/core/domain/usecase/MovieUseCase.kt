package com.example.expert.core.domain.usecase

import android.graphics.Movie
import androidx.lifecycle.LiveData
import com.example.expert.Model.DetailModel
import com.example.expert.Model.MovieModel
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovies(): Flow<List<MovieModel>>

    fun getFavoriteMovies(): Flow<List<MovieModel>>

    fun checkFavoriteMovie(id: Int): LiveData<Boolean>

    fun insertFavoriteMovie(movie: MovieModel)

    fun deleteFavoriteMovie(movie: MovieModel)

    fun getMovieDetail(id: Int): Flow<DetailModel>
}