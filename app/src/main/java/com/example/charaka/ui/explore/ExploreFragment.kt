package com.example.charaka.ui.explore

import android.content.Intent
import android.nfc.NfcAdapter.EXTRA_DATA
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charaka.R
import com.example.charaka.SearchFragment
import com.example.charaka.adapter.PostAdapter
import com.example.charaka.data.local.entity.Book
import com.example.charaka.databinding.FragmentExploreBinding
import com.example.charaka.ui.detail.DetailActivity
import com.example.charaka.utils.DataDummy
import com.example.charaka.vo.Resource
import com.example.charaka.vo.Status
import org.koin.android.viewmodel.ext.android.viewModel

class ExploreFragment : Fragment() {

    private val exploreViewModel: ExploreViewModel by viewModel()
    private lateinit var binding: FragmentExploreBinding
    private lateinit var searchView: androidx.appcompat.widget.SearchView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExploreBinding.inflate(layoutInflater)
        searchView = binding.searchView
        searchClick()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null) {
            val postAdapter = PostAdapter()
            exploreViewModel.getPosts().observe(viewLifecycleOwner, { post ->
                if(post != null){
                    when(post.status){
                        Status.LOADING -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            postAdapter.setPost(post.data!!)
                            postAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            binding.ivNotFound.visibility = View.VISIBLE
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

    private fun searchClick(){
        searchView.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                val newQuery = query?.replace("\\s".toRegex(), "")
                Log.d("QUERY", newQuery!!)
                val mBundle = Bundle()
                mBundle.putString(SearchFragment.EXTRA_DATA, newQuery)

                val mSearchFragment = SearchFragment()

                mSearchFragment.arguments = mBundle

                val mFragmentManager = fragmentManager
                mFragmentManager?.beginTransaction()?.apply {
                    replace(
                        R.id.nav_host_fragment,
                        mSearchFragment,
                        SearchFragment::class.java.simpleName
                    )
                    addToBackStack(null)
                    commit()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}