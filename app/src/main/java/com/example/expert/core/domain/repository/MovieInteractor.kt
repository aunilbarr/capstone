package com.example.expert.core.domain.repository

import androidx.lifecycle.LiveData
import com.example.expert.Model.DetailModel
import com.example.expert.Model.MovieModel
import com.example.expert.core.domain.usecase.MovieUseCase
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val movieRepository: IMovieRepository): MovieUseCase {
    override fun getAllMovies(): Flow<List<MovieModel>> = movieRepository.getAllMovies()
    override fun getMovieDetail(id: Int): Flow<DetailModel> = movieRepository.getMovieDetail(id)
    override fun getFavoriteMovies(): Flow<List<MovieModel>> = movieRepository.getFavoriteMovies()
    override fun checkFavoriteMovie(id: Int): LiveData<Boolean> = movieRepository.checkFavoriteMovie(id)
    override fun insertFavoriteMovie(movie: MovieModel) = movieRepository.insertMovie(movie)
    override fun deleteFavoriteMovie(movie: MovieModel) = movieRepository.deleteMovie(movie)
}