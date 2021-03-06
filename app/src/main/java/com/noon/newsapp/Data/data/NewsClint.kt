package com.noon.newsapp.Data.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsClint {

     private const val BAS_URL : String = "https://newsapi.org/v2/"
    const val API_KEY : String = "4953cbce156b4f44b5a8037332045a90"

     private val okHttp : OkHttpClient.Builder = OkHttpClient.Builder()

     private val builder : Retrofit.Builder = Retrofit.Builder().
         baseUrl(BAS_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .client(okHttp.build())

     private val retrofit : Retrofit = builder.build()

     fun <T> buildService (serviveType : Class <T>) : T {
         return retrofit.create(serviveType)
     }



}