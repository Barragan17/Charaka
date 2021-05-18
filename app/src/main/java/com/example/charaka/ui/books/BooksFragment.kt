package com.example.charaka.ui.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charaka.R
import com.example.charaka.adapter.BooksAdapter
import com.example.charaka.databinding.FragmentBooksBinding
import com.example.charaka.utils.DataDummy

class BooksFragment : Fragment() {

    private lateinit var booksViewModel: BooksViewModel
    private lateinit var binding: FragmentBooksBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        booksViewModel =
            ViewModelProvider(this).get(BooksViewModel::class.java)
        binding = FragmentBooksBinding.inflate(layoutInflater)
        val view: View? = binding.root

        // for test purposes ignore the mvvm model
        binding.rvBest.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val listBookAdapter = BooksAdapter(DataDummy.generateBooks())
        binding.rvBest.adapter = listBookAdapter

        return view
    }
}