package com.noon.newsapp.Data

import android.app.Application
import com.noon.data.pojo.di.networkModule
import com.noon.newsapp.Data.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NewsApp)
            modules(listOf(appModule, networkModule))
        }
    }
}