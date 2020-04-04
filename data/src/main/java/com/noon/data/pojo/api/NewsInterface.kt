package com.noon.data.pojo.api

import com.noon.data.pojo.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {

    @GET("top-headlines")
    suspend fun getNews (@Query("country") country :String,
                 @Query("apiKey") apiKey : String

    ) : Call<News>
}