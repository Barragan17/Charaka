package com.example.charaka.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charaka.R
import com.example.charaka.adapter.PostAdapter
import com.example.charaka.databinding.FragmentPostLikedBinding
import com.example.charaka.utils.DataDummy

class PostLikedFragment : Fragment() {

    private lateinit var binding: FragmentPostLikedBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentPostLikedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postLikedAdapter = PostAdapter()
        postLikedAdapter.setPost(DataDummy.generatePosts())
        binding.rvPostLiked.layoutManager = LinearLayoutManager(context)
        binding.rvPostLiked.setHasFixedSize(true)
        binding.rvPostLiked.adapter = postLikedAdapter
        binding.rvPostLiked.visibility = View.VISIBLE
    }
}