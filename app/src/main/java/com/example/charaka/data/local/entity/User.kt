package com.example.charaka.data.local.entity

data class User(
    val id: String,
    val name: String,
    val username: String,
    val postLiked: ArrayList<Post>,
    val postSaved: ArrayList<Post>,
    val wantsToRead: Int,
    val friends: ArrayList<User>,
    val groups: ArrayList<Groups>
)
