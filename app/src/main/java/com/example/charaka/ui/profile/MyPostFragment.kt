package com.example.charaka.ui.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charaka.R
import com.example.charaka.adapter.PostAdapter
import com.example.charaka.databinding.FragmentMyPostBinding
import com.example.charaka.ui.home.HomeViewModel
import com.example.charaka.utils.DataDummy
import com.example.charaka.vo.Status
import org.koin.android.viewmodel.ext.android.viewModel


class MyPostFragment : Fragment() {

    private lateinit var binding: FragmentMyPostBinding
    private val homeViewModel: HomeViewModel by viewModel()

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

        homeViewModel.getCreatedPost().observe(viewLifecycleOwner, { postCreated ->
            binding.rvMyPost.visibility = View.VISIBLE
            postAdapter.setPost(postCreated)
            Log.d("POST CREATED", postCreated.toString())
        })

        with(binding.rvMyPost){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = postAdapter
        }
    }
}