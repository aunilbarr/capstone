package com.example.expert.core.di

import androidx.room.Room
import com.example.expert.core.ui.RecyclerViewAdapter
import com.example.expert.core.data.source.remote.network.ApiService
import com.example.expert.core.domain.repository.IMovieRepository
import com.example.expert.core.domain.repository.MovieInteractor
import com.example.expert.core.domain.usecase.MovieUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val databaseModule = module {
    factory { get<com.example.expert.core.data.source.local.room.movieDatabase>().movieDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            com.example.expert.core.data.source.local.room.movieDatabase::class.java, "movie.db"
        ).fallbackToDestructiveMigration().build()
    }
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
    single { com.example.expert.core.data.source.local.LocalDataSource(get()) }
    single { com.example.expert.core.data.source.remote.RemoteDataSource(get()) }
    single<IMovieRepository> {
        com.example.expert.core.data.MovieRepository(
            get(),
            get()
        )
    }
}

val recyclerViewModule = module {
    factory { RecyclerViewAdapter() }
}