package com.example.charaka.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.local.entity.Post
import com.example.charaka.data.remote.response.BookResponse
import com.example.charaka.data.remote.response.ItemsItem
import com.example.charaka.network.ApiConfig
import com.example.charaka.utils.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    fun searchBooks(search: String): LiveData<List<ItemsItem>>{
        val resultBooks = MutableLiveData<List<ItemsItem>>()
        ApiConfig.getApiService().getSearchBooks(search).enqueue(object : Callback<BookResponse>{
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                if(response.isSuccessful){
                    resultBooks.value = response.body()?.items!!
                    Log.i("Books Asu", response.body()!!.items.toString())
                } else {
                    Log.e("Error", "Error Asuuu")
                }
            }

            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                Log.e("On Failure", t.message.toString())
            }
        })
        Log.d("RESULTTTTT", resultBooks.value.toString())
        return resultBooks
    }
}
