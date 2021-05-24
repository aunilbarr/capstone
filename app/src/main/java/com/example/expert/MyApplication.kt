package com.example.expert

import android.app.Application
import com.example.expert.core.di.*
import com.example.fayyadhaunilbarr.core.di.*
import com.google.android.play.core.splitcompat.SplitCompatApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication :  SplitCompatApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    useCaseModule,
                    viewModelModule,
                    networkModule,
                    repositoryModule,
                    recyclerViewModule
                )
            )
        }
    }
}