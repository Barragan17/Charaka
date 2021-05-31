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
import com.example.charaka.databinding.FragmentBooksBinding
import com.example.charaka.databinding.FragmentHomeBinding
import com.example.charaka.utils.DataDummy
import com.example.charaka.vo.Status
import org.koin.android.viewmodel.ext.android.viewModel

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

        homeViewModel.getAllPosts().observe(viewLifecycleOwner, { posts ->
            if(posts != null) {
                when(posts.status){
                    Status.SUCCESS -> {
                        postAdapter.setPost(posts.data!!)
                        postAdapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        Toast.makeText(context, "There is some mistakes", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        with(binding.rvPosts){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = postAdapter
        }

        binding.fabButton.setOnClickListener {
            val intent = Intent(context, AddPostActivity::class.java)
            startActivity(intent)
        }

    }
}