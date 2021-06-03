package com.example.charaka.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.charaka.R
import com.example.charaka.data.local.entity.User
import com.example.charaka.ui.profile.ProfileActivity
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val userFirebase = FirebaseAuth.getInstance().currentUser
        if(userFirebase != null){
            val name = userFirebase.displayName
            val email = userFirebase.email
            val photo = userFirebase.photoUrl
            Log.d("DATA", "$name + $email + $photo")
        }

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                    R.id.navigation_home, R.id.navigation_explore, R.id.navigation_books
            )
        )
        user = intent.getParcelableExtra(EXTRA_USER)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem)= when(item.itemId) {
        R.id.action_profile -> {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra(ProfileActivity.EXTRA_USERS, user)
            startActivity(intent)
            true
        } else -> {
            super.onOptionsItemSelected(item)
        }
    }
}