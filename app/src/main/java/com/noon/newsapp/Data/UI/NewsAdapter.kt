package com.noon.newsapp.Data.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.noon.newsapp.Data.UI.NewsAdapter.NewstViewHolder
import com.noon.newsapp.Data.pojo.NewsModel
import com.noon.newsapp.R
import com.squareup.picasso.Picasso
import java.util.*
import kotlinx.android.synthetic.main.news_adapter_layout.*
import java.lang.Exception
import kotlin.collections.ArrayList

class NewsAdapter (): RecyclerView.Adapter<NewstViewHolder>() {
    val newsList: ArrayList<NewsModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewstViewHolder {
        return NewstViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.news_adapter_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewstViewHolder, position: Int) {
        val news : NewsModel = newsList[position]
        holder.news_author?.text = news.author
        holder.news_date?.text = news.publishedAt
        holder.news_name?.text = news.name
        holder.news_title?.text = news.title
        var image = news.urlToImage



        Picasso.get()
            .load(image)
            .into(holder.news_image, object: com.squareup.picasso.Callback {
                override fun onSuccess() {
                    //set animations here

                }

                override fun onError(e: Exception?) {
                }
            })

    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun setList(moviesList: List<NewsModel?>?) {}

    inner class NewstViewHolder(itemView: View) : ViewHolder(itemView) {
        var news_title: TextView = itemView.findViewById(R.id.news_title) as TextView
        var news_name: TextView? = itemView.findViewById(R.id.news_name) as TextView
        var news_author: TextView? = itemView.findViewById(R.id.news_author) as TextView
        var news_date: TextView? = itemView.findViewById(R.id.news_date) as TextView
        var news_image: ImageView? = itemView.findViewById(R.id.news_image) as ImageView


    }
}