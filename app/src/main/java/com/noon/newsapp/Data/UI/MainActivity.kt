package com.noon.newsapp.Data.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.noon.newsapp.Data.pojo.NewsModel
import com.noon.newsapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter : NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var newsViewModel : NewsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)


        initRecycleView()
        newsViewModel.getNews()
        newsViewModel.mutableLiveData.observe(this, object :Observer<List<NewsModel>>{
            override fun onChanged(t: List<NewsModel>) {
                newsAdapter.submitList(t)
            }

        })
    }

    private fun initRecycleView () {
        recycle_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            newsAdapter = NewsAdapter()
            adapter = newsAdapter
        }
    }
}
