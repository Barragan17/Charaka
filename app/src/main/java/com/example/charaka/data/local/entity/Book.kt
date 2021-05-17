package com.example.charaka.data.local.entity

data class Book (
    val bookId: Int,
    val bookTitle: String,
    val bookCover: String,
    val bookAuthor: String,
    val bookRatings: Int,
    val bookReviews: Int,
    val bookDesc: String)