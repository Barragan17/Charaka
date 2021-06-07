package com.example.charaka.ui.profile

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.ViewParent
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.charaka.R
import com.example.charaka.adapter.PagerAdapter
import com.example.charaka.data.local.entity.User
import com.example.charaka.databinding.ActivityProfileBinding
import com.example.charaka.ui.login.SignInActivity
import com.example.charaka.ui.settings.SettingActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USERS = "extra_users"
    }

    private lateinit var binding: ActivityProfileBinding
    private lateinit var mUser: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUser = FirebaseDatabase.getInstance().getReference("users")

        val sectionsPagerAdapter = PagerAdapter(this)
        val viewPager: ViewPager2 = binding.viewPager
        viewPager.isUserInputEnabled = false
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            when (position){
                0 -> tab.setIcon(R.drawable.ic_baseline_menu_24)
                1 -> tab.setIcon(R.drawable.ic_baseline_bookmark_border_24)
                2 -> tab.setIcon(R.drawable.ic_baseline_favorite_border_24)
                3 -> tab.setIcon(R.drawable.ic_baseline_person_24)
            }
        }.attach()

        connectDatabase()
    }

    private fun connectDatabase(){
        val fireUser = FirebaseAuth.getInstance().currentUser
        var user: User?
        Log.d("EMAIL", fireUser?.email.toString())
        mUser.orderByChild("email").equalTo(fireUser?.email).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(userSnapshot in snapshot.children){
                    user = userSnapshot.getValue(User::class.java)
                    Log.d("User", user.toString())
                    populateUser(user)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Errorrrrrrr", error.message)
            }

        })
    }

    private fun populateUser(user: User?){
        Glide.with(this)
                .load(R.drawable.portrait_placeholder)
                .centerCrop()
                .into(binding.ivProfile)
        binding.tvName.text = user?.name
        binding.tvUserName.text = user?.username
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem)= when(item.itemId) {
        R.id.action_settings -> {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
            true
        } else -> {
            super.onOptionsItemSelected(item)
        }
    }
}