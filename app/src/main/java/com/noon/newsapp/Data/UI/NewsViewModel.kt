package com.noon.newsapp.Data.UI


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.noon.newsapp.Data.data.NewsClint
import com.noon.newsapp.Data.data.NewsInterface
import com.noon.newsapp.Data.pojo.NewsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.CacheRequest


class NewsViewModel : ViewModel() {

    var mutableLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()

    val newsInterface: NewsInterface = NewsClint.buildService(NewsInterface::class.java)
    val requestCall: Call<List<NewsModel>> = newsInterface.getBusinessNews()

    fun getNews () {
        requestCall.enqueue(object : Callback<List<NewsModel>>{
            override fun onFailure(call: Call<List<NewsModel>>, t: Throwable) {
                Log.e("Retrive Data failed", t.toString())
            }

            override fun onResponse(
                call: Call<List<NewsModel>>,
                response: Response<List<NewsModel>>
            ) {
                if (response.isSuccessful){
                    mutableLiveData.value = response.body()!!
                }
            }

        })
    }

}