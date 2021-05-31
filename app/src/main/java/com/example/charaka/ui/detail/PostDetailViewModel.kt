package com.example.charaka.ui.detail

import androidx.lifecycle.ViewModel
import com.example.charaka.data.DataRepository
import com.example.charaka.data.local.entity.Post

class PostDetailViewModel(private val dataRepository: DataRepository): ViewModel() {
    fun setPostLiked(post: Post, state: Boolean) = dataRepository.setLikedPosts(post, state)

    fun setPostSaved(post: Post, state: Boolean) = dataRepository.setSavedPost(post, state)

}