package com.example.expert.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.expert.core.domain.usecase.MovieUseCase

class favoriteViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    val favorites = movieUseCase.getFavoriteMovies().asLiveData()
}