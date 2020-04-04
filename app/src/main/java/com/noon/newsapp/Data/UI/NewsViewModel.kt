package com.noon.newsapp.Data.UI


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noon.data.pojo.model.Article
import com.noon.data.pojo.model.News
import com.noon.data.pojo.repo.APIReposostery
import kotlinx.coroutines.launch


class NewsViewModel (private val repo : APIReposostery)  : ViewModel() {


    val _articles = MutableLiveData<List<Article>>()  // 2
    val isLoading = MutableLiveData<Boolean>()

    init {
        retrieveNews()   // 3
    }

    private fun retrieveNews() {
        viewModelScope.launch {
            isLoading.value = true
            _articles.value = repo.getNews()

            isLoading.value = false
        }
    }


//    var TAG : String = "NewsViewModel"
//
//    val apiInterface : com.noon.data.pojo.api.NewsInterface = repo.apiClient!!.create(
//        com.noon.data.pojo.api.NewsInterface::class.java)
//
//    var country : String = Utils.country
//    val requestCall: Call<News> = apiInterface.getNews(country,API_KEY)
//
//    fun getNews () {
//
//        requestCall.enqueue(object : Callback<News> {
//            override fun onResponse(call: Call<News>, response: Response<News>) {
//                if (response.isSuccessful) {
//                 mutableLiveData.value = response.body()?.articles
//
//                }
//                Log.e(TAG + "syccessfll", response.toString())
//
//            }
//
//            override fun onFailure(call: Call<News>, t: Throwable) {
//                Log.e(TAG, t.toString())
//
//            }
//
//        }
//        )
//    }

}

