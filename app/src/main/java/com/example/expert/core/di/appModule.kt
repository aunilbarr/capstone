package com.example.expert.core.di

import com.example.expert.ViewModel.DetailViewModel
import com.example.expert.ViewModel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}