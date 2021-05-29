package com.example.charaka.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charaka.R
import com.example.charaka.adapter.PostAdapter
import com.example.charaka.databinding.FragmentMyPostBinding
import com.example.charaka.utils.DataDummy


class MyPostFragment : Fragment() {

    private lateinit var binding: FragmentMyPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyPostBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postAdapter = PostAdapter()
        postAdapter.setPost(DataDummy.generatePosts())
        binding.rvMyPost.layoutManager = LinearLayoutManager(context)
        binding.rvMyPost.setHasFixedSize(true)
        binding.rvMyPost.adapter = postAdapter
        binding.rvMyPost.visibility = View.VISIBLE
    }
}