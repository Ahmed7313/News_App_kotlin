package com.noon.newsapp.Data.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.noon.newsapp.Data.pojo.Article
import com.noon.newsapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter : NewsAdapter
    var TAG : String = "btates"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var newsViewModel : NewsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)


 //       initRecycleView()

        recycle_view.setHasFixedSize(true)
        recycle_view.layoutManager = LinearLayoutManager(this)
        recycle_view.itemAnimator = DefaultItemAnimator()

        newsViewModel.getNews()

        newsViewModel.mutableLiveData.observe(this, object :Observer<List<Article>>{
            override fun onChanged(t: List<Article>) {
                var articleAdapter = NewsAdapter(t, this@MainActivity)
                recycle_view.adapter = articleAdapter

            }

        })
    }

//    private fun initRecycleView () {
//        recycle_view.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            newsAdapter = NewsAdapter()
//            adapter = newsAdapter
//        }
//    }
}
