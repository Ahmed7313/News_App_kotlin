package com.noon.data.pojo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.noon.data.pojo.model.Article

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