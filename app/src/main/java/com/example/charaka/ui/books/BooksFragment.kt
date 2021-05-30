package com.example.charaka.ui.books

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
import com.example.charaka.R
import com.example.charaka.adapter.BooksAdapter
import com.example.charaka.adapter.PostAdapter
import com.example.charaka.databinding.FragmentBooksBinding
import com.example.charaka.ui.detail.DetailActivity
import com.example.charaka.utils.DataDummy
import com.example.charaka.vo.Status
import org.koin.android.viewmodel.ext.android.viewModel
import kotlin.math.log

class BooksFragment : Fragment() {

    private val booksViewModel: BooksViewModel by viewModel()
    private lateinit var binding: FragmentBooksBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBooksBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null) {
            val bestBooksAdapter = BooksAdapter()
            val popularBookAdapter = BooksAdapter()
            val recommendBookAdapter = BooksAdapter()
            booksViewModel.getBooks().observe(viewLifecycleOwner, { books ->
                if(books != null){
                    when(books.status){
                        Status.SUCCESS -> {
                            bestBooksAdapter.setBook(books.data!!)
                            bestBooksAdapter.notifyDataSetChanged()

                            popularBookAdapter.setBook(books.data)
                            popularBookAdapter.notifyDataSetChanged()

                            recommendBookAdapter.setBook(books.data)
                            recommendBookAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            Toast.makeText(context, "There is some mistakes", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding.rvBest) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = bestBooksAdapter
            }
            with(binding.rvPopular) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = popularBookAdapter
            }
            with(binding.rvRecommendations) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = recommendBookAdapter
            }

            bestBooksAdapter.onItemClick = { bestBook ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_BOOKS, bestBook)
                startActivity(intent)
            }

            popularBookAdapter.onItemClick = { popularBook ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_BOOKS, popularBook)
                startActivity(intent)
            }

            recommendBookAdapter.onItemClick = { recommendBook ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_BOOKS, recommendBook)
                startActivity(intent)
            }
        }
    }
}