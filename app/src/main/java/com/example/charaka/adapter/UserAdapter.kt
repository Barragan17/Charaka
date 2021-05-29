package com.example.charaka.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.charaka.data.local.entity.User
import com.example.charaka.databinding.ItemUserBinding

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var listUsers = ArrayList<User>()
    var onItemClick: ((User) -> Unit)? = null

    fun setUser(user: List<User>){
        if(user == null) return
        listUsers.clear()
        listUsers.addAll(user)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User){
            with(binding){
                tvName.text = user.name
                tvUser.text = user.username
            }
        }
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listUsers[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val userItemBinding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(userItemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val users = listUsers[position]
        holder.bind(users)
    }

    override fun getItemCount(): Int {
        return listUsers.size
    }
}