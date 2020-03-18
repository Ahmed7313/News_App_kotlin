package com.noon.newsapp.Data.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.noon.newsapp.Data.pojo.Article
import com.noon.newsapp.Data.pojo.NewsModel
import com.noon.newsapp.Data.pojo.Utils
import com.noon.newsapp.R
import com.squareup.picasso.Picasso
import java.util.*
import kotlinx.android.synthetic.main.news_adapter_layout.*
import kotlinx.android.synthetic.main.news_adapter_layout.view.*
import java.lang.Exception
import kotlin.collections.ArrayList

class NewsAdapter (): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var newsList: List<Article> = ArrayList()

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

    fun submitList (itemList : List<Article>) {
        newsList = itemList
    }

    inner class NewstViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        var progressbar: ProgressBar = itemView.adapterProgressBar
        var title: TextView = itemView.title
        var desc: TextView = itemView.desc
        var newsAuthor: TextView = itemView.news_author
        var publishedDate: TextView = itemView.publishedAt
        var source: TextView = itemView.source
        var time: TextView = itemView.time
        var newsImage: ImageView = itemView.news_image

        fun bind(newsModel: Article) {
            title.setText(newsModel.title)
            desc.setText(newsModel.description)
            newsAuthor.setText(newsModel.author)
            publishedDate.setText(newsModel.publishedAt)
            progressbar.visibility
            source.setText(newsModel.source.name)


            time.setText("u2022" + Utils.DateToTimeFormat(newsModel.publishedAt))
            publishedDate.setText(Utils.DateFormat(newsModel.publishedAt))

            val requestOption = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

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