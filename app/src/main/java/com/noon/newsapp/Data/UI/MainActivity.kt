package com.noon.newsapp.Data.UI

import android.app.SearchManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.noon.newsapp.Data.pojo.Article
import com.noon.newsapp.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        val searchManager =
            getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView = menu.findItem(R.id.action_search).actionView as SearchView
        val searchMenuItem = menu.findItem(R.id.action_search)
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setQueryHint("Search Latest News...")
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.length > 2) {

                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Type more than two letters!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        searchMenuItem.icon.setVisible(false, false)
        return true
    }

}
