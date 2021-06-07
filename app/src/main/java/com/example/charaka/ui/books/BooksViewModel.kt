package com.example.charaka.ui.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.charaka.data.DataRepository
import com.example.charaka.data.local.entity.Book
import com.example.charaka.vo.Resource

class BooksViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun getBestBooks(): LiveData<Resource<List<Book>>> = dataRepository.getBestBooks()

    fun getPopularBooks(): LiveData<Resource<List<Book>>> = dataRepository.getPopularBooks()

    fun getRecommendedBooks(): LiveData<Resource<List<Book>>> = dataRepository.getRecommendedBooks()
}