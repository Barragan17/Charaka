package com.example.charaka.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.charaka.data.local.entity.Book
import com.example.charaka.databinding.ItemBooksBinding

class BooksAdapter(private var list: List<Book>): RecyclerView.Adapter<BooksAdapter.BooksViewHolder>(){
    private var listBooks = ArrayList<Book>()

    inner class BooksViewHolder(private val binding: ItemBooksBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(books: Book){
            with(binding){
                tvTitle.text = books.bookTitle
                tvAuthor.text = books.bookAuthor
                rbBooks.rating = books.bookRatings.toFloat()
                Glide.with(itemView.context)
                    .load(books.bookCover)
                    .centerCrop()
                    .into(ivBooks)
            }
        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BooksAdapter.BooksViewHolder {
        val booksItemBinding = ItemBooksBinding.inflate(LayoutInflater.from(parent.context))
        return BooksViewHolder(booksItemBinding)
    }

    override fun onBindViewHolder(holder: BooksAdapter.BooksViewHolder, position: Int) {
        val books = listBooks[position]
        holder.bind(books)
    }

    override fun getItemCount(): Int {
        return listBooks.size
    }

}