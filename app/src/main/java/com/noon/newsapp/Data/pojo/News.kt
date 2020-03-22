package com.noon.newsapp.Data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class News (@SerializedName("statues")
            @Expose
            var statues : String,
            @SerializedName("totalResults")
            @Expose
            var totalResults : Int,
            @SerializedName("articles")
            @Expose
            var articles : List<Article>
){

}