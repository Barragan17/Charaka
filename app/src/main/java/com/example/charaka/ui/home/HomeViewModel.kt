package com.example.charaka.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.charaka.data.DataRepository

class HomeViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getAllPosts() = dataRepository.getAllPosts()
}