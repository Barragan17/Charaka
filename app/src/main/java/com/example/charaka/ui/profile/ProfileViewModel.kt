package com.example.charaka.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.example.charaka.data.DataRepository
import com.example.charaka.data.local.entity.Book

class ProfileViewModel(private val dataRepository: DataRepository): ViewModel() {
    fun getWantToRead(): LiveData<List<Book>> = dataRepository.getWantToRead()

    fun getRead(): LiveData<List<Book>> = dataRepository.getRead()
}