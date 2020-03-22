package com.noon.newsapp.Data.UI

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.noon.newsapp.Data.pojo.Article
import com.noon.newsapp.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter : NewsAdapter
    private var articles: List<Article> = ArrayList()
    private var adapter: NewsAdapter? = null
    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var newsViewModel : NewsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)


        //       initRecycleView()

        recycleView.setHasFixedSize(true)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.itemAnimator = DefaultItemAnimator()

        newsViewModel.getNews()

        newsViewModel.mutableLiveData.observe(this, object :Observer<List<Article>>{
            override fun onChanged(t: List<Article>) {
                adapter = NewsAdapter(t, this@MainActivity)
                articles = t
                recycleView.adapter = adapter

            }

        })
    }

}
