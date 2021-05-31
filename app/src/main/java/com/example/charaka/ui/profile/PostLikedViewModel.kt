package com.example.charaka.ui.profile

import androidx.lifecycle.ViewModel
import com.example.charaka.data.DataRepository

class PostLikedViewModel(private val dataRepository: DataRepository): ViewModel() {
    fun getPostLiked() = dataRepository.getLikedPosts()
}