package com.example.charaka.ui.detail

import androidx.lifecycle.ViewModel
import com.example.charaka.data.DataRepository
import com.example.charaka.data.local.entity.Book

class DetailViewModel(private val dataRepository: DataRepository): ViewModel() {
    fun setWantToRead(book: Book, state: Boolean) = dataRepository.setWantToRead(book, state)

    fun setRead(book: Book, state: Boolean) = dataRepository.setRead(book, state)

    fun setRating(book: Book, rating: Int) = dataRepository.setRating(book, rating)
}