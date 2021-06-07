package com.example.charaka.ui.detail

import android.content.Intent
import android.graphics.Color
import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.charaka.AddPostActivity
import com.example.charaka.R
import com.example.charaka.data.local.entity.Book
import com.example.charaka.databinding.ActivityDetailBinding
import com.example.charaka.ui.profile.ProfileActivity
import com.shashank.sony.fancytoastlib.FancyToast
import org.koin.android.ext.android.bind
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_BOOKS = "extra_best"
    }

    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailBook: Book
    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        detailBook = intent.getParcelableExtra(EXTRA_BOOKS)!!

        supportActionBar?.title = detailBook.bookTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        populateBooks(detailBook)
    }

    private fun populateBooks(detailBook: Book?) {
        detailBook?.let {
            binding.tvTitleDetails.text = detailBook.bookTitle
            binding.tvAuthorDetails.text = detailBook.bookAuthor
            binding.tvRating.text = detailBook.bookRatings.toString()
            binding.tvDescriptionDetail.text = detailBook.bookDesc
            binding.ratingRate.rating = detailBook.userRatings.toFloat()
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
                binding.tvRatingText.text = "Your Rating"
            }
        }
    }

    private fun setWantToRead(state: Boolean){
        if(state) {
            binding.btnWantToRead.setBackgroundColor(resources.getColor(R.color.white))
            binding.btnWantToRead.setTextColor(resources.getColor(R.color.blue_200))
        } else {
            binding.btnWantToRead.setBackgroundColor(resources.getColor(R.color.blue_200))
            binding.btnWantToRead.setTextColor(resources.getColor(R.color.white))
        }
    }

    private fun setBookRead(state: Boolean){
        if(state) {
            binding.btnRead.setBackgroundColor(resources.getColor(R.color.white))
            binding.btnRead.setTextColor(resources.getColor(R.color.blue_200))
        } else {
            binding.btnRead.setBackgroundColor(resources.getColor(R.color.blue_200))
            binding.btnRead.setTextColor(resources.getColor(R.color.white))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.book_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem)= when(item.itemId) {
        R.id.book_menu -> {
            val intent = Intent(this, AddPostActivity::class.java)
            intent.putExtra(AddPostActivity.EXTRA_POST, detailBook)
            startActivity(intent)
            true
        } else -> {
            super.onOptionsItemSelected(item)
        }
    }
}