package com.example.charaka.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charaka.R
import com.example.charaka.adapter.PostAdapter
import com.example.charaka.databinding.FragmentExploreBinding
import com.example.charaka.utils.DataDummy
import com.example.charaka.vo.Resource
import com.example.charaka.vo.Status
import org.koin.android.viewmodel.ext.android.viewModel

class ExploreFragment : Fragment() {

    private val exploreViewModel: ExploreViewModel by viewModel()
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

        if(activity != null) {
            val postAdapter = PostAdapter()
            exploreViewModel.getPosts().observe(viewLifecycleOwner, { post ->
                if(post != null){
                    when(post.status){
                        Status.SUCCESS -> {
                            postAdapter.setPost(post.data!!)
                            postAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            Toast.makeText(context, "There is some mistakes", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding.rvPosts) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = postAdapter
            }
        }
    }
}