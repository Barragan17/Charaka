package com.example.charaka.data

import androidx.lifecycle.LiveData
import com.example.charaka.data.local.LocalDataSource
import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.local.entity.Post
import com.example.charaka.data.remote.ApiResponse
import com.example.charaka.data.remote.RemoteDataSource
import com.example.charaka.utils.AppExecutors
import com.example.charaka.vo.Resource
import kotlinx.coroutines.newFixedThreadPoolContext

class DataRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): DataDataSource{
    override fun getAllBooks(): LiveData<Resource<List<Book>>> {
        return object : NetworkBoundResource<List<Book>, List<Book>>(appExecutors){
            override fun loadFromDB(): LiveData<List<Book>> {
                return localDataSource.getAllBooks()
            }

            override fun shouldFetch(data: List<Book>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<Book>>> {
                 return remoteDataSource.getAllBooks()
            }

            override fun saveCallResult(data: List<Book>) {
                val bookList = ArrayList<Book>()
                for(response in data){
                    val books = Book(response.bookId,
                    response.bookTitle,
                    response.bookCover,
                    response.bookAuthor,
                    response.bookRatings,
                    response.bookReviews,
                    response.bookDesc)
                    bookList.add(books)
                }
                localDataSource.insertBooks(bookList)
            }
        }.asLiveData()
    }

    override fun getAllPosts(): LiveData<Resource<List<Post>>> {
        return object: NetworkBoundResource<List<Post>, List<Post>>(appExecutors){
            override fun loadFromDB(): LiveData<List<Post>> =
                localDataSource.getAllPosts()

            override fun shouldFetch(data: List<Post>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<Post>>> =
                remoteDataSource.getAllPosts()

            override fun saveCallResult(data: List<Post>) {
                val postsList = ArrayList<Post>()
                for (response in data){
                    val posts = Post(response.id,
                    response.userName,
                    response.userComment,
                    response.booksImage,
                    response.booksTitle,
                    response.booksAuthor,
                    response.booksRating,
                    response.likes,
                    response.comments)
                    postsList.add(posts)
                }
                localDataSource.insertPosts(postsList)
            }
        }.asLiveData()
    }

    override fun getRead(): LiveData<List<Book>> =
        localDataSource.getRead()

    override fun getWantToRead(): LiveData<List<Book>> =
        localDataSource.getWantToRead()

    override fun getLikedPosts(): LiveData<List<Post>> =
        localDataSource.getLikedPosts()

    override fun getSavedPosts(): LiveData<List<Post>> =
        localDataSource.getSavedPost()

    override fun setRead(book: Book, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setBooksRead(book, state) }
    }

    override fun setWantToRead(book: Book, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setBooksWantToRead(book, state) }
    }

    override fun setLikedPosts(post: Post, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setPostLiked(post, state) }
    }

    override fun setSavedPost(post: Post, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setPostSaved(post, state) }
    }

    override fun setRating(book: Book, rating: Int) {
        appExecutors.diskIO().execute { localDataSource.setRatings(book, rating) }
    }

}