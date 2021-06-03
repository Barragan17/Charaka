package com.example.charaka.data.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "bookentities")
@Parcelize
data class Book (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "bookId")
    val bookId: String,

    @ColumnInfo(name = "bookTitle")
    val bookTitle: String,

    @ColumnInfo(name = "bookCover")
    val bookCover: String,

    @ColumnInfo(name = "bookAuthor")
    val bookAuthor: String,

    @ColumnInfo(name = "bookRatings")
    var bookRatings: Int = 0,

    @ColumnInfo(name = "userRatings")
    var userRatings: Int = 0,

    @ColumnInfo(name = "bookReviews")
    var bookReviews: Int = 0,

    @ColumnInfo(name = "bookDesc")
    val bookDesc: String,

    @ColumnInfo(name = "read")
    var read: Boolean = false,

    @ColumnInfo(name = "wantToRead")
    var wantToRead: Boolean = false) : Parcelable
