package com.example.charaka.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import com.example.charaka.R
import com.example.charaka.databinding.ActivitySplashBinding
import com.example.charaka.ui.login.SignInActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private var timeDelay: Long = 2500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        android.os.Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }, timeDelay)
    }
}