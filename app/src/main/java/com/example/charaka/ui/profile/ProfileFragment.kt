package com.example.charaka.ui.profile

import android.os.Bundle
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

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

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

        val bookAdapter = BooksAdapter()
        bookAdapter.setBook(DataDummy.generateBooks())

        binding.rvWantRead.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvWantRead.isNestedScrollingEnabled = false
        binding.rvWantRead.setHasFixedSize(true)
        binding.rvWantRead.adapter = bookAdapter
        binding.rvWantRead.visibility = View.VISIBLE

        binding.rvRead.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvRead.setHasFixedSize(true)
        binding.rvRead.adapter = bookAdapter
        binding.rvRead.visibility = View.VISIBLE

        val userAdapter = UserAdapter()
        userAdapter.setUser(DataDummy.generateUsers())

        binding.rvFriends.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvFriends.setHasFixedSize(true)
        binding.rvFriends.adapter = userAdapter
        binding.rvFriends.visibility = View.VISIBLE


    }
}