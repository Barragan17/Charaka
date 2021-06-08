package com.example.charaka.network

import com.example.charaka.BuildConfig
import com.example.charaka.data.remote.response.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("v1/volumes")
    fun getSearchBooks(
        @Query("q") q: String,
        @Query("key") key: String = BuildConfig.API_KEY
    ): Call<BookResponse>

    @GET("feeds")
    fun getPost(): Call<FeedsResponse>

    @Headers("Content-Type: application/json")
    @POST("feeds")
    fun postPosts(
        @Body postData: PostInfo
    ): Call<PostResponse>

    @GET("books")
    fun getBestBooks(): Call<BooksResponse>

    @GET("predictions")
    fun getRecommendBooks(): Call<BooksResponse>
}