package com.example.expert.core.di

import androidx.room.Room
import com.example.expert.core.ui.RecyclerViewAdapter
import com.example.expert.core.data.source.remote.network.ApiService
import com.example.expert.core.domain.repository.IMovieRepository
import com.example.expert.core.domain.repository.MovieInteractor
import com.example.expert.core.domain.usecase.MovieUseCase
import net.sqlcipher.database.SupportFactory
import net.sqlcipher.database.SQLiteDatabase
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val databaseModule = module {
    factory { get<com.example.expert.core.data.source.local.room.movieDatabase>().movieDao() }
    single {
        val passphrase = SQLiteDatabase.getBytes("expert".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            com.example.expert.core.data.source.local.room.movieDatabase::class.java, "movie.db"
        )
            .fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "api.themoviedb.org"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/+vqZVAzTqUP8BGkfl88yU7SQ3C8J2uNEa55B7RZjEg0=")
            .add(hostname, "sha256/JSMzqOOrtyOT1kmau6zKhgT676hGgczD5VMdRMyJZFA=")
            .add(hostname, "sha256/++MBgDH5WGvL9Bcn5Be30cRcL0f5O+NyoXuWtQdX1aI=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
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