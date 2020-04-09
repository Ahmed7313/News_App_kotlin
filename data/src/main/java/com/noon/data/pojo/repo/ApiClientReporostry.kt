package com.noon.data.pojo.repo

import com.noon.data.pojo.api.NewsInterface
import com.noon.data.pojo.model.Article
import com.noon.data.pojo.model.CONSTANTS
import com.noon.data.pojo.model.News
import com.noon.data.pojo.model.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APIReposostery (val newsInterface: NewsInterface)  {

    var articles : List<Article> ?= null

    suspend fun getNews () : List<Article>?  {
         var country = Utils.country
         return newsInterface.getNews(country, CONSTANTS.API_KEY).articles

    }


//    enqueue(object : Callback<News>{
//        override fun onFailure(call: Call<News>, t: Throwable) {
//
//        }
//
//        override fun onResponse(call: Call<News>, response: Response<News>) {
//            articles = response.body()?.articles
//        }
//    })
//    return articles
}