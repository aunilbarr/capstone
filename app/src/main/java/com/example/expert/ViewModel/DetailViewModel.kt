package com.example.expert.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.expert.core.domain.model.DetailModel
import com.example.expert.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun getDetail(id: Int): LiveData<DetailModel> = movieUseCase.getMovieDetail(id).asLiveData()
}