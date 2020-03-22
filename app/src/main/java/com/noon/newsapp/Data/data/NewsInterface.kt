package com.noon.newsapp.Data.data

import com.noon.newsapp.Data.pojo.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {

    @GET("top-headlines")
    fun getNews (@Query("country") country :String,
                 @Query("apiKey") apiKey : String

    ) : Call<News>
}