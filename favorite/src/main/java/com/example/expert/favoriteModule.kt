package com.example.expert

import com.example.expert.favorite.favoriteViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { favoriteViewModel(get()) }
}