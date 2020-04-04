package com.noon.data.pojo.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noon.data.pojo.api.NewsInterface
import com.noon.data.pojo.di.provideRetrofit
import com.noon.data.pojo.model.Article
import com.noon.data.pojo.model.CONSTANTS
import com.noon.data.pojo.model.CONSTANTS.BASE_URL
import com.noon.data.pojo.model.News
import com.noon.data.pojo.model.Utils
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class APIReposostery (val newsInterface: NewsInterface)  {


    var articles : List<Article> ?= null

    suspend fun getNews () : List<Article>?  {
         var country = Utils.country
         newsInterface.getNews(country, CONSTANTS.API_KEY).enqueue(object : Callback<News>{
             override fun onFailure(call: Call<News>, t: Throwable) {

             }

             override fun onResponse(call: Call<News>, response: Response<News>) {
                 articles = response.body()?.articles
             }
         })
        return articles
    }

}