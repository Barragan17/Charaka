package com.example.charaka.network

import com.example.charaka.BuildConfig
import com.example.charaka.data.remote.response.BookResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/volumes")
    fun getSearchBooks(
        @Query("q") q: String,
        @Query("key") key: String = BuildConfig.API_KEY
    ): Call<BookResponse>
}