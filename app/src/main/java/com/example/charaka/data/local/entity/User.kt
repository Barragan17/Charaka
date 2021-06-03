package com.example.charaka.data.local.entity

import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties
import kotlinx.parcelize.Parcelize

@IgnoreExtraProperties
@Parcelize
data class User(
        val id: String = "",
        val name: String = "",
        val username: String = "",
        val email: String = "",
        val password: String = "",
        var postLiked: ArrayList<Post> = ArrayList(),
        var postSaved: ArrayList<Post> = ArrayList(),
        val wantsToRead: Int = 0,
        val friends: ArrayList<User> = ArrayList(),
        val groups: ArrayList<Groups> = ArrayList()
): Parcelable
