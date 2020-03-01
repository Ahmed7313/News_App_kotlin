package com.noon.newsapp.Data.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.noon.newsapp.Data.pojo.NewsModel
import com.noon.newsapp.R
import com.squareup.picasso.Picasso
import java.util.*
import kotlinx.android.synthetic.main.news_adapter_layout.*
import kotlinx.android.synthetic.main.news_adapter_layout.view.*
import java.lang.Exception
import kotlin.collections.ArrayList

class NewsAdapter (): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var newsList: List<NewsModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return NewstViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.news_adapter_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when (holder){
            is NewstViewHolder->{
                holder.bind(newsList.get(position))
            }
        }
    }

    fun submitList (itemList : List<NewsModel>) {
        newsList = itemList
    }

    inner class NewstViewHolder constructor(
        itemView : View
    ) : RecyclerView.ViewHolder(itemView){

        var newsTitle: TextView = itemView.news_title
        var newsName: TextView = itemView.news_name
        var newsAuthor: TextView = itemView.news_author
        var newsDate: TextView = itemView.news_date
        var newsImage: ImageView = itemView.news_image

        fun bind (newsModel: NewsModel){
            newsTitle.setText(newsModel.title)
            newsName.setText(newsModel.name)
            newsAuthor.setText(newsModel.author)
            newsDate.setText(newsModel.publishedAt)

            val requestOption = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOption)
                .load(newsModel.urlToImage)
                .into(newsImage)

        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}