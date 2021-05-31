package com.example.charaka.ui.detail

import android.graphics.Color
import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.charaka.R
import com.example.charaka.data.local.entity.Book
import com.example.charaka.databinding.ActivityDetailBinding
import com.shashank.sony.fancytoastlib.FancyToast
import org.koin.android.ext.android.bind
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_BOOKS = "extra_best"
    }

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModel()

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
            binding.tvRating.text = detailBook.bookRatings.toString()
            binding.tvDescriptionDetail.text = detailBook.bookDesc
            Glide.with(this)
                    .load(detailBook.bookCover)
                    .centerCrop()
                    .into(binding.ivCover)
            var statusWantToRead = detailBook.wantToRead
            var statusBookRead = detailBook.read
            setWantToRead(statusWantToRead)
            setBookRead(statusBookRead)
            binding.btnWantToRead.setOnClickListener {
                statusWantToRead = !statusWantToRead
                detailViewModel.setWantToRead(detailBook, statusWantToRead)
                setWantToRead(statusWantToRead)
            }
            binding.btnRead.setOnClickListener {
                statusBookRead = !statusBookRead
                detailViewModel.setRead(detailBook, statusBookRead)
                setBookRead(statusBookRead)
            }
            binding.ratingRate.setOnRatingBarChangeListener { _, rating, _ ->
                detailViewModel.setRating(detailBook, rating.toInt())
                FancyToast.makeText(this, "Rating Saved", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show()
            }
        }
    }

    private fun setWantToRead(state: Boolean){
        if(state){
            binding.btnWantToRead.setBackgroundColor(resources.getColor(R.color.white))
            binding.btnWantToRead.setTextColor(resources.getColor(R.color.blue_200))
        }else {
            binding.btnWantToRead.setBackgroundColor(resources.getColor(R.color.blue_200))
            binding.btnWantToRead.setTextColor(resources.getColor(R.color.white))
        }
    }

    private fun setBookRead(state: Boolean){
        if(state){
            binding.btnRead.setBackgroundColor(resources.getColor(R.color.white))
            binding.btnRead.setTextColor(resources.getColor(R.color.blue_200))
        } else {
            binding.btnRead.setBackgroundColor(resources.getColor(R.color.blue_200))
            binding.btnRead.setTextColor(resources.getColor(R.color.white))
        }
    }
}