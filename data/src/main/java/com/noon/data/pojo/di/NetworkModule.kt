package com.noon.data.pojo.di

import com.noon.data.pojo.api.NewsInterface
import com.noon.data.pojo.model.CONSTANTS
import com.noon.data.pojo.repo.APIReposostery
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



    val networkModule  = module {

        single { APIReposostery(get()) }

        single { provideRetrofit(get(), get()) }

        single { provideOkHttp() }

        single { provideJSON() }

        single { provideAPIInterface(get())}
    }

fun provideAPIInterface ( retrofit: Retrofit) {
    retrofit.create(NewsInterface::class.java)
}

fun provideRetrofit (  providOkHttp : OkHttpClient, provideJSON : GsonConverterFactory ) = Retrofit.Builder().baseUrl(CONSTANTS.BASE_URL)
            .client(providOkHttp)
            .addConverterFactory(provideJSON)
            .build()

fun provideOkHttp () = OkHttpClient.Builder()

fun provideJSON () = GsonConverterFactory.create()
