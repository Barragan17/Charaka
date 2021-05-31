package com.example.charaka.ui.profile

import androidx.lifecycle.ViewModel
import com.example.charaka.data.DataRepository

class PostSavedViewModel(private val dataRepository: DataRepository): ViewModel() {
    fun getPostSaved() = dataRepository.getSavedPosts()
}