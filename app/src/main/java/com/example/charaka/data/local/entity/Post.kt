package com.example.charaka.data.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "postentities")
@Parcelize
data class Post(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "userName")
    val userName: String,

    @ColumnInfo(name = "userComment")
    val userComment: String,

    @ColumnInfo(name = "booksImage")
    val booksImage: String,

    @ColumnInfo(name = "booksTitle")
    val booksTitle: String,

    @ColumnInfo(name = "booksAuthor")
    val booksAuthor: String,

    @ColumnInfo(name = "booksRating")
    val booksRating: Int,

    @ColumnInfo(name = "likes")
    val likes: Int,

    @ColumnInfo(name = "comments")
    val comments: Int,

    @ColumnInfo(name = "liked")
    var liked: Boolean = false,

    @ColumnInfo(name = "saved")
    var saved: Boolean = false
) : Parcelable
