package com.example.charaka.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.charaka.ui.profile.MyPostFragment
import com.example.charaka.ui.profile.PostLikedFragment
import com.example.charaka.ui.profile.PostSavedFragment
import com.example.charaka.ui.profile.ProfileFragment

class PagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> {
                fragment = MyPostFragment()
            }
            1 -> {
                fragment = PostLikedFragment()
            }
            2 -> {
                fragment = PostSavedFragment()
            }
            3 -> {
                fragment = ProfileFragment()
            }
        }
        return fragment as Fragment
    }

}