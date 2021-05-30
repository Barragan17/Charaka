package com.example.charaka.data.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
        val id: String = "",
        val name: String = "",
        val username: String = "",
        var postLiked: ArrayList<Post> = ArrayList(),
        var postSaved: ArrayList<Post> = ArrayList(),
        val wantsToRead: Int = 0,
        val friends: ArrayList<User> = ArrayList(),
        val groups: ArrayList<Groups> = ArrayList()
): Parcelable
