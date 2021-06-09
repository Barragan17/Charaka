package com.example.charaka.ui.books

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.charaka.data.DataRepository
import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.remote.response.BookResponse
import com.example.charaka.data.remote.response.BooksResponse
import com.example.charaka.network.ApiConfig
import com.example.charaka.vo.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun getBestBooks(): LiveData<Resource<List<Book>>> = dataRepository.getBestBooks()

    fun getPopularBooks(): LiveData<Resource<List<Book>>> = dataRepository.getPopularBooks()

    fun getRecommendedBooks(): LiveData<List<Book>>{
        val listSearch = MutableLiveData<List<Book>>()
        val listBooks = ArrayList<Book>()

        ApiConfig.getCustomApiService().getRecommendBooks().enqueue(object : Callback<BooksResponse> {
            override fun onResponse(call: Call<BooksResponse>, response: Response<BooksResponse>) {
                if(response.isSuccessful){
                    val responseList = response.body()!!.docs
                    for (data in responseList!!){
                        val books = Book(data.id.toString(),
                                data.title!!,
                                data.imageUrl ?: "Unavailable",
                                data.authors ?: "Unavailable",
                                false,
                                false,
                                true,
                                data.averageRating?.toInt()?:0,
                                0,
                                0,
                                data.originalTitle ?: "Unavailable")
                        listBooks.add(books)
                    }
                    listSearch.postValue(listBooks)
                    Log.i("Books Asu", listBooks.toString())
                } else {
                    Log.e("Error", response.message())
                }
            }

            override fun onFailure(call: Call<BooksResponse>, t: Throwable) {
                Log.e("ERROR", t.message!!)
            }
        })
        return listSearch
    }
}