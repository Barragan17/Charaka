package com.example.charaka.ui.detail

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.charaka.data.local.entity.Post
import com.example.charaka.databinding.ActivityPostDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class PostDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_POST = "extra_post"
    }

    private lateinit var binding: ActivityPostDetailBinding
    private val postDetailViewModel: PostDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailPost = intent.getParcelableExtra<Post>(EXTRA_POST)

        supportActionBar?.title = "Detail Post"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        populatePost(detailPost)
    }

    private fun populatePost(detailPost: Post?){
        detailPost?.let {
            binding.tvUsername.text = detailPost.userName
            binding.tvComment.text = detailPost.userComment
            Glide.with(this)
                .load(detailPost.booksImage)
                .centerCrop()
                .into(binding.ivImage)
            binding.tvTitle.text = detailPost.booksTitle
            binding.tvAuthor.text = detailPost.booksAuthor
            binding.ratingBar.rating = detailPost.booksRating.toFloat()
            var statusLiked = detailPost.liked
            var statusSaved = detailPost.saved
            Log.d("PostSaved", statusSaved.toString())
            Log.d("PostLiked", statusLiked.toString())
            setPostLiked(statusLiked)
            setPostSaved(statusSaved)
            binding.ivLike.setOnClickListener {
                statusLiked = !statusLiked
                postDetailViewModel.setPostLiked(detailPost, statusLiked)
                setPostLiked(statusLiked)
            }
            binding.ivSave.setOnClickListener {
                statusSaved = !statusSaved
                postDetailViewModel.setPostSaved(detailPost, statusSaved)
                setPostSaved(statusSaved)
            }
        }
    }

    private fun setPostLiked(state: Boolean){
        if(state){
            binding.ivLike.setColorFilter(Color.RED)
        } else {
            binding.ivLike.setColorFilter(Color.parseColor("#F5F5F5"))
        }
    }

    private fun setPostSaved(state: Boolean){
        if(state){
            binding.ivSave.setColorFilter(Color.BLUE)
        } else {
            binding.ivSave.setColorFilter(Color.parseColor("#F5F5F5"))
        }
    }
}