package com.noon.data.pojo.di

import android.provider.SyncStateContract
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.noon.data.pojo.api.NewsInterface
import com.noon.data.pojo.model.CONSTANTS
import com.noon.data.pojo.repo.APIReposostery
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



    val networkModule : Module = module {

        single {   // 2
            okHttp()  // 3
        }
        single {
            retrofit(get())  // 4
        }
        single {
            get<Retrofit>().create(NewsInterface::class.java)   // 5
        }

        single { APIReposostery(get()) }

        single { providesGson() }
    }



private fun okHttp() = OkHttpClient.Builder()
    .build()

private fun retrofit( gson : Gson) = Retrofit.Builder()
    .callFactory(OkHttpClient.Builder().build())
    .baseUrl(CONSTANTS.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

private fun providesGson(): Gson =
    GsonBuilder()
        .setLenient()
        .setDateFormat("MM/dd/yyyy")
        .create()

//
//        single { APIReposostery(get()) }
//
//        single { provideRetrofit(get(), get()) }
//
//        single { provideOkHttp() }
//
//        single { provideJSON() }
//
//        single { provideAPIInterface(get())}
//    }
//
//fun provideAPIInterface ( retrofit: Retrofit) {
//    retrofit.create(NewsInterface::class.java)
//}
//
//fun provideRetrofit (  providOkHttp : OkHttpClient, provideJSON : GsonConverterFactory ) = Retrofit.Builder()
//            .baseUrl(CONSTANTS.BASE_URL)
//            .client(providOkHttp)
//            .addConverterFactory(provideJSON)
//            .build()
//
//fun provideOkHttp () = OkHttpClient.Builder()
//
//fun provideJSON () = GsonConverterFactory.create()
