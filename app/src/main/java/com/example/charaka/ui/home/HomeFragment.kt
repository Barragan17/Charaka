package com.example.charaka.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charaka.AddPostActivity
import com.example.charaka.R
import com.example.charaka.adapter.PostAdapter
import com.example.charaka.data.remote.response.PostInfo
import com.example.charaka.databinding.FragmentBooksBinding
import com.example.charaka.databinding.FragmentHomeBinding
import com.example.charaka.utils.DataDummy
import com.example.charaka.vo.Status
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.http.POST

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postAdapter = PostAdapter()

        homeViewModel.getCreatedPost().observe(viewLifecycleOwner, { posts ->
            if(posts.isNotEmpty()) {
                Log.d("POST", posts.toString())
                binding.progressBar.visibility = View.GONE
                binding.tvEmpty.visibility = View.GONE
                binding.animation.visibility = View.GONE
                postAdapter.setPost(posts)
                postAdapter.notifyDataSetChanged()
            } else {
                Log.d("EMPTY", "EMPTY COKKKKKKKKK")
                binding.progressBar.visibility = View.GONE
                binding.tvEmpty.visibility = View.VISIBLE
                binding.animation.visibility = View.VISIBLE
            }
        })

        with(binding.rvPosts){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = postAdapter
        }
    }
}