package com.example.charaka.data.remote.response

import com.google.gson.annotations.SerializedName

data class PostInfo(
    @SerializedName("userid")
    val userId: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("desc")
    val desc: String,

    @SerializedName("book_id")
    val bookId: String
)