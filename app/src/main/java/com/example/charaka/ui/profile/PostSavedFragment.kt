package com.example.charaka.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charaka.R
import com.example.charaka.adapter.PostAdapter
import com.example.charaka.databinding.FragmentPostSavedBinding
import com.example.charaka.utils.DataDummy

class PostSavedFragment : Fragment() {

    private lateinit var binding: FragmentPostSavedBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPostSavedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postSavedAdapter = PostAdapter()
        postSavedAdapter.setPost(DataDummy.generatePosts())

        binding.rvPostSaved.layoutManager = LinearLayoutManager(context)
        binding.rvPostSaved.setHasFixedSize(true)
        binding.rvPostSaved.adapter = postSavedAdapter
        binding.rvPostSaved.visibility = View.VISIBLE
    }
}