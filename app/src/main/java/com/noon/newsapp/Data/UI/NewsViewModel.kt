package com.noon.newsapp.Data.UI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.noon.newsapp.Data.data.NewsClint
import com.noon.newsapp.Data.pojo.NewsModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.security.auth.callback.Callback

class NewsViewModel : ViewModel() {

    var mutableLiveData : MutableLiveData <List<NewsModel>> = MutableLiveData()

     fun getNews() {
        var newsClint : NewsClint = NewsClint()
         newsClint.getNewsINSTANCE().getNews().enqueue( object : retrofit2.Callback<List<NewsModel>> {
             override fun onFailure(call: Call<List<NewsModel>>, t: Throwable) {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
             }

             override fun onResponse(
                 call: Call<List<NewsModel>>,
                 response: Response<List<NewsModel>>
             ) {
                 mutableLiveData.value = response.body()
             }

         })


    }
}