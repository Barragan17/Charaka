package com.example.charaka.ui.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.charaka.data.DataRepository
import com.example.charaka.data.local.entity.Book
import com.example.charaka.vo.Resource

class BooksViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun getBooks(): LiveData<Resource<List<Book>>> = dataRepository.getAllBooks()
}