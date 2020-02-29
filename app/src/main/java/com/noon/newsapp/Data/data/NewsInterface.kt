package com.noon.newsapp.Data.data

import com.noon.newsapp.Data.pojo.NewsModel
import retrofit2.Call
import retrofit2.http.GET

interface NewsInterface {

    @GET("v2/top-headlines?country=us&category=business&apiKey=${NewsClint.API_KEY}")
    fun getBusinessNews () : Call<List<NewsModel>>
}