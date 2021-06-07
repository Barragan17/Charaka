package com.example.charaka.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.charaka.data.local.LocalDataSource
import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.local.entity.Post
import com.example.charaka.data.remote.ApiResponse
import com.example.charaka.data.remote.RemoteDataSource
import com.example.charaka.data.remote.response.Docs
import com.example.charaka.data.remote.response.DocsItem
import com.example.charaka.data.remote.response.ItemsItem
import com.example.charaka.data.remote.response.PostInfo
import com.example.charaka.utils.AppExecutors
import com.example.charaka.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.newFixedThreadPoolContext

class DataRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): DataDataSource{
    override fun getBestBooks(): LiveData<Resource<List<Book>>> {
        return object : NetworkBoundResource<List<Book>, List<Book>>(appExecutors){
            override fun loadFromDB(): LiveData<List<Book>> {
                return localDataSource.getAllBestBook()
            }

            override fun shouldFetch(data: List<Book>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<Book>>> {
                 return remoteDataSource.getBestBooks()
            }

            override fun saveCallResult(data: List<Book>) {
                val bookList = ArrayList<Book>()
                for(response in data){
                    val books = Book(response.bookId,
                    response.bookTitle,
                    response.bookCover,
                    response.bookAuthor,
                            bookIsBest = true,
                            bookIsPopular = false,
                            bookIsRecommend = false,
                    response.bookRatings,
                    response.userRatings,
                    response.bookReviews,
                    response.bookDesc)
                    bookList.add(books)
                }
                localDataSource.insertBooks(bookList)
            }
        }.asLiveData()
    }

    override fun getPopularBooks(): LiveData<Resource<List<Book>>> {
        return object : NetworkBoundResource<List<Book>, List<Book>>(appExecutors){
            override fun loadFromDB(): LiveData<List<Book>> =
                localDataSource.getAllPopularBook()

            override fun shouldFetch(data: List<Book>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<Book>>> =
                remoteDataSource.getPopularBooks()

            override fun saveCallResult(data: List<Book>) {
                val bookList = ArrayList<Book>()
                for(response in data){
                    val books = Book(response.bookId,
                            response.bookTitle,
                            response.bookCover,
                            response.bookAuthor,
                            bookIsBest = false,
                            bookIsPopular = true,
                            bookIsRecommend = false,
                            response.bookRatings,
                            response.userRatings,
                            response.bookReviews,
                            response.bookDesc)
                    bookList.add(books)
                }
                localDataSource.insertBooks(bookList)
            }
        }.asLiveData()
    }

    override fun getRecommendedBooks(): LiveData<Resource<List<Book>>> {
        return object : NetworkBoundResource<List<Book>, List<Docs>>(appExecutors){
            override fun loadFromDB(): LiveData<List<Book>> =
                localDataSource.getAllRecommendedBook()

            override fun shouldFetch(data: List<Book>?): Boolean =
                    data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<Docs>>> =
                remoteDataSource.getRecommendedBooks()

            override fun saveCallResult(data: List<Docs>) {
                val bookList = ArrayList<Book>()
                for(response in data){
                    val books = Book(response.bookId.toString(),
                            response.originalTitle!!,
                            response.imageUrl!!,
                            response.authors!!,
                            bookIsBest = false,
                            bookIsPopular = false,
                            bookIsRecommend = true,
                            response.averageRating?.toInt()!!,
                            0,
                            0,
                            response.originalTitle)
                    bookList.add(books)
                }
                localDataSource.insertBooks(bookList)
            }
        }.asLiveData()
    }

    override fun getAllPosts(): LiveData<Resource<List<Post>>> {
        return object: NetworkBoundResource<List<Post>, List<DocsItem>>(appExecutors){
            override fun loadFromDB(): LiveData<List<Post>> =
                localDataSource.getAllPosts()

            override fun shouldFetch(data: List<Post>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<DocsItem>>> =
                remoteDataSource.getAllPosts()

            override fun saveCallResult(data: List<DocsItem>) {
                val postsList = ArrayList<Post>()
                for (response in data){
                    val posts = Post(response.id!!,
                    response.id,
                    response.doc?.description!!,
                            response.doc.bookId!!,
                    response.bookdoc?.imageUrl!!,
                    response.bookdoc.title!!,
                    response.bookdoc.authors!!,
                    response.bookdoc.averageRating!!,
                    response.bookdoc.ratingsCount!!,
                    response.bookdoc.booksCount!!)
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

    override fun getCreatedPosts(): LiveData<List<Post>> =
        localDataSource.getCreatedPost()

    override fun setRead(book: Book, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setBooksRead(book, state) }
    }

    override fun addPosts(postInfo: PostInfo) {
        remoteDataSource.addPost(postInfo)
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

    override fun setCreatedPost(post: Post) {
        appExecutors.diskIO().execute { localDataSource.setCreatedPost(post) }
    }

    override fun setRating(book: Book, rating: Int) {
        appExecutors.diskIO().execute { localDataSource.setRatings(book, rating) }
    }

}