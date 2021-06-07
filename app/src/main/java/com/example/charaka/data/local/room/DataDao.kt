package com.example.charaka.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.local.entity.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface DataDao {
    @Query("SELECT * FROM bookentities")
    fun getBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM bookentities WHERE isBest = 1")
    fun getBestBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM bookentities WHERE isPopular = 1")
    fun getPopularBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM bookentities WHERE isRecommend = 1")
    fun getRecommendedBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM postentities")
    fun getPost(): LiveData<List<Post>>

    @Query("SELECT * FROM postentities WHERE liked = 1")
    fun getLikedPost(): LiveData<List<Post>>

    @Query("SELECT * FROM postentities WHERE saved = 1")
    fun getSavedPost(): LiveData<List<Post>>

    @Query("SELECT * FROM postentities WHERE isCreated = 1")
    fun getCreatedPost(): LiveData<List<Post>>

    @Query("SELECT * FROM bookentities WHERE read = 1")
    fun getRead(): LiveData<List<Book>>

    @Query("SELECT * FROM bookentities WHERE wantToRead = 1")
    fun getWantToRead(): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBooks(books: List<Book>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(posts: List<Post>)

    @Update
    fun updateBooks(book: Book)

    @Update
    fun updatePost(post: Post)
}