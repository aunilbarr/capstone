package com.example.expert

import com.example.expert.core.di.useCaseModule
import com.example.expert.core.di.viewModelModule
import com.google.android.play.core.splitcompat.SplitCompatApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : SplitCompatApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}