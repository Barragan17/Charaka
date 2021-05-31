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
import org.koin.android.viewmodel.ext.android.viewModel

class PostSavedFragment : Fragment() {

    private lateinit var binding: FragmentPostSavedBinding
    private val postSavedViewModel: PostSavedViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPostSavedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postSavedAdapter = PostAdapter()
        postSavedViewModel.getPostSaved().observe(viewLifecycleOwner, { postSaved ->
            binding.rvPostSaved.visibility = View.VISIBLE
            postSavedAdapter.setPost(postSaved)
        })

        with(binding.rvPostSaved){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = postSavedAdapter
        }
    }
}