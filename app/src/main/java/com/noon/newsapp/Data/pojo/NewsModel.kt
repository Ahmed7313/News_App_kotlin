package com.noon.newsapp.Data.pojo

data class NewsModel (var id : String,
                      var name : String,
                      var author : String,
                      var title : String,
                      var description : String,
                      var url : String,
                      var urlToImage : Int,
                      var publishedAt : String,
                      var content : String)
