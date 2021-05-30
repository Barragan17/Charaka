package com.example.charaka.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.local.entity.Post
import com.example.charaka.utils.DataDummy

class RemoteDataSource {

    fun getAllBooks(): LiveData<ApiResponse<List<Book>>>{
        val resultBooks = MutableLiveData<ApiResponse<List<Book>>>()
        resultBooks.value = ApiResponse.success(DataDummy.generateBooks())

        return resultBooks
    }

    fun getAllPosts(): LiveData<ApiResponse<List<Post>>>{
        val resultPosts = MutableLiveData<ApiResponse<List<Post>>>()
        resultPosts.value = ApiResponse.success(DataDummy.generatePosts())

        return resultPosts
    }
}