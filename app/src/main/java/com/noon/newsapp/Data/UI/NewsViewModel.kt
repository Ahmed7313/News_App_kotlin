package com.noon.newsapp.Data.UI


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.noon.newsapp.Data.data.ApiClient
import com.noon.newsapp.Data.data.NewsClint
import com.noon.newsapp.Data.data.NewsInterface
import com.noon.newsapp.Data.pojo.Article
import com.noon.newsapp.Data.pojo.News
import com.noon.newsapp.Data.pojo.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsViewModel : ViewModel() {

    var mutableLiveData: MutableLiveData<List<Article>> = MutableLiveData()
    var TAG : String = "NewsViewModel"

    val apiInterface : NewsInterface = ApiClient.apiClient!!.create(NewsInterface::class.java)

    var country : String = Utils.country
    val requestCall: Call<News> = apiInterface.getNews(country,ApiClient.API_KEY)

    fun getNews () {

        requestCall.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                if (response.isSuccessful) {
                    mutableLiveData.value = response.body()?.articles

                }
                Log.e(TAG + "syccessfll", response.toString())

            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e(TAG, t.toString())

            }

        }
        )


//        requestCall.enqueue(object : Callback<List<Article>>{
//            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
//                Log.e("Retrive Data failed", t.toString())
//            }
//
//            override fun onResponse(
//                call: Call<List<Article>>,
//                response: Response<List<Article>>
//            ) {
//                if (response.isSuccessful){
//                    mutableLiveData.value = response.body()!!
//                }
//            }
//
//        })
    }

}

