package com.example.charaka.ui.login

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.charaka.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFont()

        binding.tvToSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun changeFont(){
        val typefaceLight: Typeface = Typeface.createFromAsset(assets, "Poppins-Light.ttf")
        val typefaceBold: Typeface = Typeface.createFromAsset(assets, "Poppins-Bold.ttf")

        binding.textView.typeface = typefaceBold
        binding.tvUsername.typeface = typefaceLight
        binding.tvPassword.typeface = typefaceLight
        binding.btnSignIn.typeface = typefaceBold
        binding.tvToSignUp.typeface = typefaceLight
        binding.tvDont.typeface = typefaceLight
    }
}