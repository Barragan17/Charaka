package com.example.charaka

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charaka.adapter.SearchAdapter
import com.example.charaka.data.local.entity.Book
import com.example.charaka.databinding.FragmentHomeBinding
import com.example.charaka.databinding.FragmentSearchBinding
import com.example.charaka.ui.explore.SearchViewModel
import org.koin.android.ext.android.bind
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    companion object {
        var EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: FragmentSearchBinding
    private val searchViewModel: SearchViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if(arguments != null){
            val searchList = arguments?.getString(EXTRA_DATA)
            showRv(searchList!!)
        }
    }

    private fun showRv(query: String) {
        val searchAdapter = SearchAdapter()

        searchViewModel.search(query).observe(viewLifecycleOwner, { searchitems ->
            searchAdapter.setSearch(searchitems)
            searchAdapter.notifyDataSetChanged()
        })

        with(binding.rvSearch){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = searchAdapter
        }
    }
}