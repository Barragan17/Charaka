package com.example.charaka.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.local.entity.Post
import com.example.charaka.data.remote.response.*
import com.example.charaka.network.ApiConfig
import com.example.charaka.utils.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    fun getBestBooks(): LiveData<ApiResponse<List<Docs>>>{
        val resultBooks = MutableLiveData<ApiResponse<List<Docs>>>()
        ApiConfig.getCustomApiService().getBestBooks().enqueue(object: Callback<BooksResponse>{
            override fun onResponse(call: Call<BooksResponse>, response: Response<BooksResponse>) {
                if(response.isSuccessful){
                    resultBooks.value = ApiResponse.success(response.body()?.docs!!)
                } else {
                    Log.e("Error", "Error : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<BooksResponse>, t: Throwable) {
                Log.e("Error","Error: ${t.message}")
            }
        })
        return resultBooks
    }

    fun getPopularBooks(): LiveData<ApiResponse<List<Book>>>{
        val resultPopularBooks = MutableLiveData<ApiResponse<List<Book>>>()
        resultPopularBooks.value = ApiResponse.success(DataDummy.generatePopularBooks())

        return resultPopularBooks
    }

//    fun getRecommendedBooks(): LiveData<ApiResponse<List<Docs>>>{
//        val resultBooks = MutableLiveData<ApiResponse<List<Docs>>>()
//        ApiConfig.getCustomApiService().getRecommendBooks().enqueue(object : Callback<BooksResponse>{
//            override fun onResponse(call: Call<BooksResponse>, response: Response<BooksResponse>) {
//                if(response.isSuccessful){
//                    resultBooks.value = ApiResponse.success(response.body()?.docs!!)
//                } else {
//                    Log.e("Error", "Error : ${response.message()}")
//                }
//            }
//
//            override fun onFailure(call: Call<BooksResponse>, t: Throwable) {
//                Log.e("Error", "Error : ${t.message}")
//            }
//        })
//        return resultBooks
//    }

    fun getRecommendBooks(): LiveData<ApiResponse<List<Docs>>>{
        val resultBooks = MutableLiveData<ApiResponse<List<Docs>>>()
        ApiConfig.getCustomApiService().getRecommendBooks().enqueue(object: Callback<BooksResponse>{
            override fun onResponse(call: Call<BooksResponse>, response: Response<BooksResponse>) {
                if(response.isSuccessful){
                    resultBooks.value = ApiResponse.success(response.body()?.docs!!)
                } else {
                    Log.e("Error", "Error : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<BooksResponse>, t: Throwable) {
                Log.e("Error","Error: ${t.message}")
            }
        })
        return resultBooks
    }

    fun getAllPosts(): LiveData<ApiResponse<List<DocsItem>>>{
        val resultPosts = MutableLiveData<ApiResponse<List<DocsItem>>>()
        ApiConfig.getCustomApiService().getPost().enqueue(object : Callback<FeedsResponse>{
            override fun onResponse(call: Call<FeedsResponse>, response: Response<FeedsResponse>) {
                if(response.isSuccessful){
                    resultPosts.value = ApiResponse.success(response.body()?.docs!!)
                }
                else {
                    Log.e("Error", "Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<FeedsResponse>, t: Throwable) {
                Log.e("On Failure", t.message.toString())
            }
        })
        return resultPosts
    }

    fun addPost(postData: PostInfo){
        val resultPosts = MutableLiveData<ApiResponse<PostResponse>>()
        ApiConfig.getCustomApiService().postPosts(postData).enqueue(object : Callback<PostResponse>{
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                if(response.isSuccessful){
                    resultPosts.value = ApiResponse.success(response.body()!!)
                    Log.e("Result", resultPosts.value?.body?.data.toString())
                } else {
                    Log.e("Error On Response", "Ora iso nge post")
                }
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                Log.e("Error", "Ora iso nge post")
            }

        })
    }
}
