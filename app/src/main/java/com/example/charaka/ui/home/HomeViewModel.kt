package com.example.charaka.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.charaka.data.DataRepository
import com.example.charaka.data.local.entity.Post
import com.example.charaka.data.remote.response.PostInfo

class HomeViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun addPost(postInfo: PostInfo) = dataRepository.addPosts(postInfo)

    fun setCreatedPost(post: Post) = dataRepository.setCreatedPost(post)

    fun getCreatedPost() = dataRepository.getCreatedPosts()
}