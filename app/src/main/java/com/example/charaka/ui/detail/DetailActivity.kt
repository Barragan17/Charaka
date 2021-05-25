package com.example.charaka.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.charaka.R
import com.example.charaka.data.local.entity.Book
import com.example.charaka.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_BOOKS = "extra_best"
    }

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailBook = intent.getParcelableExtra<Book>(EXTRA_BOOKS)

        supportActionBar?.title = detailBook?.bookTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        populateBooks(detailBook)
    }

    private fun populateBooks(detailBook: Book?){
        detailBook?.let {
            binding.tvTitleDetails.text = detailBook.bookTitle
            binding.tvAuthorDetails.text = detailBook.bookAuthor
            binding.ratingRate.rating = detailBook.bookRatings.toFloat()
            binding.tvDescriptionDetail.text = detailBook.bookDesc
            Glide.with(this)
                    .load(detailBook.bookCover)
                    .centerCrop()
                    .into(binding.ivCover)
        }
    }
}