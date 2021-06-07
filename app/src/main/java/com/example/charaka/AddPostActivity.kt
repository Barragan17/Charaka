package com.example.charaka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.local.entity.Post
import com.example.charaka.data.local.entity.User
import com.example.charaka.data.remote.response.PostInfo
import com.example.charaka.databinding.ActivityAddPostBinding
import com.example.charaka.ui.home.HomeActivity
import com.example.charaka.ui.home.HomeViewModel
import com.example.charaka.ui.profile.ProfileActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import org.koin.android.viewmodel.ext.android.viewModel

class AddPostActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_POST = "extra_post"
    }

    private lateinit var binding: ActivityAddPostBinding
    private lateinit var detailBooks: Book
    private lateinit var mUser: DatabaseReference
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUser = FirebaseDatabase.getInstance().getReference("users")

        detailBooks = intent.getParcelableExtra(EXTRA_POST)!!

        populatePost(detailBooks!!)
    }

    private fun populatePost(book: Book){
        val fireUser = FirebaseAuth.getInstance().currentUser
        var user: User?
        Log.d("EMAIL", fireUser?.email.toString())
        mUser.orderByChild("email").equalTo(fireUser?.email).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for(userSnapshot in snapshot.children){
                    user = userSnapshot.getValue(User::class.java)
                    Log.d("User", user.toString())
                    binding.tvUsername.text = user?.username
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Errorrrrrrr", error.message)
            }

        })
        binding.tvAuthor.text = book.bookAuthor
        binding.tvTitleBooks.text = book.bookTitle
        binding.rbBooks.rating = book.userRatings.toFloat()
        Glide.with(this)
                .load(book.bookCover)
                .centerCrop()
                .into(binding.ivBooks)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.post_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        R.id.done -> {
            if(!binding.etTitle.text.toString().isBlank() && !binding.etDescription.text.toString().isBlank()) {
                val post = PostInfo("1", binding.etTitle.text.toString(), binding.etDescription.text.toString(), detailBooks.bookId)
                homeViewModel.addPost(post)
                val createdPost = Post((0..100).random().toString(), binding.tvUsername.text.toString(), binding.etDescription.text.toString(), detailBooks.bookId, detailBooks.bookCover, detailBooks.bookTitle, detailBooks.bookAuthor, detailBooks.bookRatings.toString(), "0", "0", true)
                homeViewModel.setCreatedPost(createdPost)
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
            true
        } else -> {
            super.onOptionsItemSelected(item)
        }
    }
}