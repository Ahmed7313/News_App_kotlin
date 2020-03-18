package com.noon.newsapp.Data.UI


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.noon.newsapp.Data.data.NewsClint
import com.noon.newsapp.Data.data.NewsInterface
import com.noon.newsapp.Data.pojo.Article
import com.noon.newsapp.Data.pojo.NewsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsViewModel : ViewModel() {

    var mutableLiveData: MutableLiveData<List<Article>> = MutableLiveData()

    val newsInterface: NewsInterface = NewsClint.buildService(NewsInterface::class.java)
    val requestCall: Call<List<Article>> = newsInterface.getNews("eg","business" , NewsClint.API_KEY)

    fun getNews () {
        requestCall.enqueue(object : Callback<List<Article>>{
            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                Log.e("Retrive Data failed", t.toString())
            }

            override fun onResponse(
                call: Call<List<Article>>,
                response: Response<List<Article>>
            ) {
                if (response.isSuccessful){
                    mutableLiveData.value = response.body()!!
                }
            }

        })
    }

}