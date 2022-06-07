package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class AlbumsItem(
    @SerializedName("id")
    val id: Int, // 1
    @SerializedName("title")
    val title: String, // quidem molestiae enim
    @SerializedName("userId")
    val userId: Int // 1
)