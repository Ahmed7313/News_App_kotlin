package com.noon.newsapp.Data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Source (
    @SerializedName("id")
    @Expose
    var id : String,
    @SerializedName("name")
    @Expose
    var name : String
) {
}