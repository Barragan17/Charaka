package com.example.charaka.ui.books

import android.os.Bundle
import android.util.Log
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
import kotlin.math.log

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // for test purposes ignore the mvvm model
        val bestBookAdapter = BooksAdapter()
        bestBookAdapter.setBook(DataDummy.generateBooks())
        binding.rvBest.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        Log.d("DUMMY", DataDummy.generateBooks().toString())
        binding.rvBest.setHasFixedSize(true)
        binding.rvBest.adapter = bestBookAdapter
        binding.rvBest.visibility = View.VISIBLE

        val popularBookAdapter = BooksAdapter()
        popularBookAdapter.setBook(DataDummy.generateBooks())
        binding.rvPopular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvPopular.setHasFixedSize(true)
        binding.rvPopular.adapter = popularBookAdapter
        binding.rvPopular.visibility = View.VISIBLE

        val recommendBookAdapter = BooksAdapter()
        recommendBookAdapter.setBook(DataDummy.generateBooks())
        binding.rvRecommendations.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvRecommendations.setHasFixedSize(true)
        binding.rvRecommendations.adapter = popularBookAdapter
        binding.rvRecommendations.visibility = View.VISIBLE



    }
}