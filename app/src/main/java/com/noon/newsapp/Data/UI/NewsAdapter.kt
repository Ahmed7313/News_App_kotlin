package com.noon.newsapp.Data.UI

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.noon.newsapp.Data.pojo.Article
import com.noon.newsapp.Data.pojo.Utils
import com.noon.newsapp.R
import java.net.URI.create

class NewsAdapter (
    private val articles: List<Article>,
    private val context: Context
) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    private var onItemClickListener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.news_adapter_layout, parent, false)
        return MyViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holders: MyViewHolder, position: Int) {
        val model = articles[position]
        val requestOptions = RequestOptions()
        requestOptions.placeholder(Utils.randomDrawbleColor)
        requestOptions.error(Utils.randomDrawbleColor)
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL)
        requestOptions.centerCrop()
        Glide.with(context)
            .load(model.urlToImage)
            .apply(requestOptions)
            .listener(object : RequestListener<Drawable?> {
                override fun onLoadFailed(
                    @Nullable e: GlideException?, model: Any,
                    target: Target<Drawable?>,
                    isFirstResource: Boolean
                ): Boolean {
                    holders.progressBar.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any,
                    target: Target<Drawable?>,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    holders.progressBar.visibility = View.GONE
                    return false
                }
            })
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holders.imageView)
        holders.title.text = model.title
        holders.desc.text = model.description
        holders.source.text = model.source.name
        holders.time.text = " \u2022 " + Utils.DateToTimeFormat(model.publishedAt)
        holders.published_ad.text = Utils.DateFormat(model.publishedAt)
        holders.author.text = model.author

        holders.cardView.setOnClickListener {
            val intent = Intent(context, NewsDetailActivity::class.java)
            intent.putExtra("url", model.url)
            intent.putExtra("title", model.title)
            intent.putExtra("img", model.urlToImage)
            intent.putExtra("date", model.publishedAt)
            intent.putExtra("source", model.source.name)
            intent.putExtra("author", model.author)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener?) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    inner class MyViewHolder(
        itemView: View,
        onItemClickListener: OnItemClickListener?
    ) : ViewHolder(itemView), View.OnClickListener {
        var title: TextView
        var desc: TextView
        var author: TextView
        var published_ad: TextView
        var source: TextView
        var time: TextView
        var imageView: ImageView
        var progressBar: ProgressBar
        var cardView : CardView
        var onItemClickListener: OnItemClickListener?
        override fun onClick(v: View) {
            onItemClickListener!!.onItemClick(v, adapterPosition)
        }

        init {
            itemView.setOnClickListener(this)
            title = itemView.findViewById(R.id.title)
            desc = itemView.findViewById(R.id.desc)
            author = itemView.findViewById(R.id.author)
            published_ad = itemView.findViewById(R.id.publishedAt)
            source = itemView.findViewById(R.id.source)
            time = itemView.findViewById(R.id.time)
            imageView = itemView.findViewById(R.id.img)
            progressBar = itemView.findViewById(R.id.prograss_load_photo)
            cardView = itemView.findViewById(R.id.cardView)
            this.onItemClickListener = onItemClickListener
        }
    }

}