package com.example.charaka.ui.explore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.charaka.data.DataRepository
import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.remote.response.BookResponse
import com.example.charaka.data.remote.response.ItemsItem
import com.example.charaka.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel(): ViewModel() {
    fun search(search: String): LiveData<List<Book>>{
        val listSearch = MutableLiveData<List<Book>>()
        val listBooks = ArrayList<Book>()

        ApiConfig.getApiService().getSearchBooks(search).enqueue(object : Callback<BookResponse>{
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                if(response.isSuccessful){
                    val responseList = response.body()!!.items
                    for (data in responseList!!){
                        val books = Book(data.id!!,
                        data.volumeInfo?.title!!,
                        data.volumeInfo.imageLinks?.thumbnail ?: "Unavailable",
                        data.volumeInfo.authors?.get(0) ?: "Unavailable",
                                false,
                                false,
                                false,
            data.volumeInfo.averageRating?.toInt() ?: 0.0.toInt(),
                            0,
            0,
                        data.volumeInfo.description ?: "Unavailable")
                        listBooks.add(books)
                    }
                    listSearch.postValue(listBooks)
                    Log.i("Books Asu", listBooks.toString())
                } else {
                    Log.e("Error", response.message())
                }
            }

            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                Log.e("ERROR", t.message!!)
            }
        })
        return listSearch
    }
}