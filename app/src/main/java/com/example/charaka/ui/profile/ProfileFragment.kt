package com.example.charaka.ui.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charaka.R
import com.example.charaka.adapter.BooksAdapter
import com.example.charaka.adapter.UserAdapter
import com.example.charaka.databinding.FragmentProfileBinding
import com.example.charaka.utils.DataDummy
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val profileViewModel: ProfileViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookReadAdapter = BooksAdapter()

        val booksWantToReadAdapter = BooksAdapter()

        profileViewModel.getWantToRead().observe(viewLifecycleOwner, { wantToRead->
            binding.rvWantRead.visibility = View.VISIBLE
            Log.d("Want To Read", wantToRead.toString())
            booksWantToReadAdapter.setBook(wantToRead)
        })

        profileViewModel.getRead().observe(viewLifecycleOwner, { read ->
            binding.rvRead.visibility = View.VISIBLE
            Log.d("Read", read.toString())
            bookReadAdapter.setBook(read)
        })

        with(binding.rvWantRead){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = booksWantToReadAdapter
        }

        with(binding.rvRead){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = bookReadAdapter
        }

        val userAdapter = UserAdapter()
        userAdapter.setUser(DataDummy.generateUsers())

        binding.rvFriends.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvFriends.setHasFixedSize(true)
        binding.rvFriends.adapter = userAdapter
        binding.rvFriends.visibility = View.VISIBLE
    }
}