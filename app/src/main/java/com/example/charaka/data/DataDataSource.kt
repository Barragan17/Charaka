package com.example.charaka.data

import androidx.lifecycle.LiveData
import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.local.entity.Post
import com.example.charaka.vo.Resource

interface DataDataSource {
    fun getAllBooks(): LiveData<Resource<List<Book>>>

    fun getAllPosts(): LiveData<Resource<List<Post>>>

    fun getRead(): LiveData<List<Book>>

    fun getWantToRead(): LiveData<List<Book>>

    fun getLikedPosts(): LiveData<List<Post>>

    fun getSavedPosts(): LiveData<List<Post>>

    fun setRead(book: Book, state: Boolean)

    fun setWantToRead(book: Book, state: Boolean)

    fun setLikedPosts(post: Post, state: Boolean)

    fun setSavedPost(post: Post, state: Boolean)

    fun setRating(book: Book, rating: Int)
}