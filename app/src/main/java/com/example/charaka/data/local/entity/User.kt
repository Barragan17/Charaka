package com.example.charaka.data.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
        val id: String = "",
        val name: String = "",
        val username: String = "",
        val postLiked: ArrayList<Post> = ArrayList(),
        val postSaved: ArrayList<Post> = ArrayList(),
        val wantsToRead: Int = 0,
        val friends: ArrayList<User> = ArrayList(),
        val groups: ArrayList<Groups> = ArrayList()
): Parcelable
