package com.example.charaka.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charaka.R
import com.example.charaka.adapter.PostAdapter
import com.example.charaka.databinding.FragmentExploreBinding
import com.example.charaka.utils.DataDummy

class ExploreFragment : Fragment() {

    private lateinit var exploreViewModel: ExploreViewModel
    private lateinit var binding: FragmentExploreBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExploreBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postAdapter = PostAdapter()
        postAdapter.setPost(DataDummy.generatePosts())
        binding.rvPosts.layoutManager = LinearLayoutManager(context)
        binding.rvPosts.setHasFixedSize(true)
        binding.rvPosts.adapter = postAdapter
        binding.rvPosts.visibility = View.VISIBLE
    }
}