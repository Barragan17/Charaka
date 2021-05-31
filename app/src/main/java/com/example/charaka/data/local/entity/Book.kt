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
    val bookId: Int,

    @ColumnInfo(name = "bookTitle")
    val bookTitle: String,

    @ColumnInfo(name = "bookCover")
    val bookCover: String,

    @ColumnInfo(name = "bookAuthor")
    val bookAuthor: String,

    @ColumnInfo(name = "bookRatings")
    var bookRatings: Int,

    @ColumnInfo(name = "bookReviews")
    val bookReviews: Int,

    @ColumnInfo(name = "bookDesc")
    val bookDesc: String,

    @ColumnInfo(name = "read")
    var read: Boolean = false,

    @ColumnInfo(name = "wantToRead")
    var wantToRead: Boolean = false) : Parcelable
