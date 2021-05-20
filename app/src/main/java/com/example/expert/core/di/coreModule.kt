package com.example.expert.core.di

import com.example.expert.Adapter.RecyclerViewAdapter
import com.example.expert.ViewModel.DetailViewModel
import com.example.expert.ViewModel.MainViewModel
import com.example.expert.core.data.MovieRepository
import com.example.expert.core.data.source.local.LocalDataSource
import com.example.expert.core.data.source.remote.RemoteDataSource
import com.example.expert.core.data.source.remote.network.ApiService
import com.example.expert.core.domain.repository.IMovieRepository
import com.example.expert.core.domain.repository.MovieInteractor
import com.example.expert.core.domain.usecase.MovieUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}

val networkModule = module {
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single<IMovieRepository> {
        MovieRepository(
            get(),
            get()
        )
    }
}

val recyclerViewModule = module {
    factory { RecyclerViewAdapter() }
}