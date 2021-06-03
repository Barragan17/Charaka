package com.example.charaka.ui.profile

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.ViewParent
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.charaka.R
import com.example.charaka.adapter.PagerAdapter
import com.example.charaka.data.local.entity.User
import com.example.charaka.databinding.ActivityProfileBinding
import com.example.charaka.ui.settings.SettingActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USERS = "extra_users"
    }

    private lateinit var binding: ActivityProfileBinding
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = intent.getParcelableExtra(EXTRA_USERS)
        populateProfile(user!!)

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
    }

    private fun populateProfile(user: User){
        binding.tvName.text = user.name
        binding.tvUserName.text = user.username
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem)= when(item.itemId) {
        R.id.action_settings -> {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
            true
        } else -> {
            super.onOptionsItemSelected(item)
        }
    }
}