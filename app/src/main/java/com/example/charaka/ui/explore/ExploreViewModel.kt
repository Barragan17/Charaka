package com.example.charaka.ui.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.charaka.data.DataRepository
import com.example.charaka.data.local.entity.Post
import com.example.charaka.vo.Resource

class ExploreViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun getPosts(): LiveData<Resource<List<Post>>> = dataRepository.getAllPosts()
}