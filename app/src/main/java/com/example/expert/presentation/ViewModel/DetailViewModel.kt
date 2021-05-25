package com.example.expert.presentation.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.expert.core.domain.model.DetailModel
import com.example.expert.core.domain.model.MovieModel
import com.example.expert.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun getDetail(id: Int): LiveData<DetailModel> = movieUseCase.getMovieDetail(id).asLiveData()
    fun checkFav(id: Int): LiveData<Boolean> = movieUseCase.checkFavoriteMovie(id)
    fun insertFav(movie: MovieModel) = movieUseCase.insertFavoriteMovie(movie)
    fun deleteFav(movie: MovieModel) = movieUseCase.deleteFavoriteMovie(movie)
}