package com.noon.newsapp.Data.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.noon.newsapp.Data.pojo.NewsModel
import com.noon.newsapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var newsViewModel : NewsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)

        var newsAdapter  = NewsAdapter()
        news_list_view.layoutManager = LinearLayoutManager(this)
        news_list_view.adapter = newsAdapter

        newsViewModel.getNews()
        newsViewModel.mutableLiveData.observe(this, object :Observer<List<NewsModel>>{
            override fun onChanged(t: List<NewsModel>?) {
                newsAdapter.setList(t)
            }

        })
    }
}
