package com.example.charaka.data.local.entity

data class Post(
    val id: Int,
    val userName: String,
    val userComment: String,
    val booksImage: String,
    val booksTitle: String,
    val booksAuthor: String,
    val booksRating: Int,
    val likes: Int,
    val comments: Int
)
