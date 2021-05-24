package com.example.expert.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.fayyadhaunilbarr.core.domain.usecase.MovieUseCase

class MainViewModel(private val movieUseCase: MovieUseCase): ViewModel() {
    val movie = movieUseCase.getAllMovies().asLiveData()
}