package com.example.charaka.adapter

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.charaka.data.local.entity.Book
import com.example.charaka.databinding.ItemSearchBinding

class SearchAdapter: RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    private var listSearch = ArrayList<Book>()

    fun setSearch(search: List<Book>){
        if(search == null) return
        listSearch.clear()
        listSearch.addAll(search)
        notifyDataSetChanged()
    }

    inner class SearchViewHolder(private val binding: ItemSearchBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(search: Book){
            with(binding){
                tvTitle.text = search.bookTitle
                tvAuthor.text = search.bookAuthor
                rbSearch.rating = search.bookRatings.toFloat()
                Glide.with(itemView.context)
                        .load(search.bookCover)
                        .centerCrop()
                        .into(ivCover)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.SearchViewHolder {
        val searchItemsBinding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(searchItemsBinding)
    }

    override fun onBindViewHolder(holder: SearchAdapter.SearchViewHolder, position: Int) {
        val search = listSearch[position]
        holder.bind(search)
    }

    override fun getItemCount(): Int {
        return listSearch.size
    }

}