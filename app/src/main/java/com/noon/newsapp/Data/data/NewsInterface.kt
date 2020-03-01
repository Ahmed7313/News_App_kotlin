package com.noon.newsapp.Data.data

import com.noon.newsapp.Data.pojo.NewsModel
import retrofit2.Call
import retrofit2.http.GET

interface NewsInterface {

    @GET("v2/everything?q=bitcoin&from=2020-01-29&sortBy=publishedAt&apiKey=${NewsClint.API_KEY}")
    fun getBusinessNews () : Call<List<NewsModel>>
}