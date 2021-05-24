package com.example.charaka.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.local.entity.Post
import com.example.charaka.databinding.ItemBooksBinding
import com.example.charaka.databinding.ItemPostsBinding

class PostAdapter: RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    private var listPosts = ArrayList<Post>()

    fun setPost(posts: List<Post>){
        if(posts == null) return
        listPosts.clear()
        listPosts.addAll(posts)
        notifyDataSetChanged()
    }

    inner class PostViewHolder(private val binding: ItemPostsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(posts: Post){
            with(binding){
                tvUsername.text = posts.userName
                tvAuthor.text = posts.booksAuthor
                ratingBar.rating = posts.booksRating.toFloat()
                tvUserComment.text = posts.userComment
                tvTitle.text = posts.booksTitle
                Glide.with(itemView.context)
                        .load(posts.booksImage)
                        .centerCrop()
                        .into(ivBooks)
                tvLike.text = posts.likes.toString()
                tvComment.text = posts.comments.toString()
            }
        }


    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): PostAdapter.PostViewHolder {
        val postItemBinding = ItemPostsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(postItemBinding)
    }

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        val books = listPosts[position]
        holder.bind(books)
    }

    override fun getItemCount(): Int {
        return listPosts.size
    }

}