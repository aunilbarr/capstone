package com.example.expert.presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.expert.core.domain.usecase.MovieUseCase

class MainViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getAllMovies().asLiveData()
}