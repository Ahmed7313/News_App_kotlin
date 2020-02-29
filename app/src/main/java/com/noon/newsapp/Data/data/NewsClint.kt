package com.noon.newsapp.Data.data

import com.noon.newsapp.Data.pojo.NewsModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 class NewsClint() {

      private var retrofit: Retrofit
      private var newsInterface : NewsInterface
      private val okkHttp: OkHttpClient.Builder = OkHttpClient.Builder()


      init {
            val builder: Retrofit.Builder = Retrofit.Builder()
                 .baseUrl(Companion.BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .client(okkHttp.build())
            retrofit = builder.build()

            newsInterface = retrofit.create(NewsInterface::class.java)
      }

       fun getNewsINSTANCE (): NewsClint {
           var newsClint : NewsClint = NewsClint()
           return newsClint
       }

      companion object {
          private const val BASE_URL: String = "http://newsapi.org/"
          const val API_KEY : String = "4953cbce156b4f44b5a8037332045a90"

      }

       public fun getNews () : Call<List<NewsModel>> {
             return newsInterface.getBusinessNews()
       }

}