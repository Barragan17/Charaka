package com.example.charaka.data.local

import androidx.lifecycle.LiveData
import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.local.entity.Post
import com.example.charaka.data.local.room.DataDao
import java.sql.DatabaseMetaData

class LocalDataSource(private val dataDao: DataDao) {

    fun getAllBooks(): LiveData<List<Book>> = dataDao.getBooks()

    fun getAllPosts(): LiveData<List<Post>> = dataDao.getPost()

    fun getLikedPosts(): LiveData<List<Post>> = dataDao.getLikedPost()

    fun getSavedPost(): LiveData<List<Post>> = dataDao.getSavedPost()

    fun getRead(): LiveData<List<Book>> = dataDao.getRead()

    fun getWantToRead(): LiveData<List<Book>> = dataDao.getWantToRead()

    fun insertBooks(books: List<Book>) = dataDao.insertBooks(books)

    fun insertPosts(post: List<Post>) = dataDao.insertPosts(post)

    fun setBooksRead(books: Book, newState: Boolean){
        books.read = newState
        dataDao.updateBooks(books)
    }

    fun setBooksWantToRead(books: Book, newState: Boolean){
        books.wantToRead = newState
        dataDao.updateBooks(books)
    }

    fun setPostSaved(post: Post, newState: Boolean){
        post.liked = newState
        dataDao.updatePost(post)
    }

    fun setPostLiked(post: Post, newState: Boolean){
        post.saved = newState
        dataDao.updatePost(post)
    }

    fun updateBooks(books: Book){
        dataDao.updateBooks(books)
    }

    fun updatePosts(post: Post){
        dataDao.updatePost(post)
    }
}