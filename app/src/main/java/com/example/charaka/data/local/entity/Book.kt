package com.example.charaka.data.local.entity

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book (
    val bookId: Int,
    val bookTitle: String,
    val bookCover: String,
    val bookAuthor: String,
    val bookRatings: Int,
    val bookReviews: Int,
    val bookDesc: String) : Parcelable