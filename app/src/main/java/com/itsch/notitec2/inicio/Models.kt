package com.itsch.notitec2.inicio

import com.google.gson.annotations.SerializedName

/**
 * Created by Isma-Developer on 1/26/2018.
 */

data class PostResponse(@SerializedName("status")var status: Boolean,
                        var banners: List<Banner>,
                        var posts: List<Post>)

data class Banner(var id: Int,
                  var name: String,
                  var imageUrl: String,
                  var type: String)

data class Post(var id: Int,
                var name: String,
                var date: String,
                var description: String,
                var imageUrl: String)