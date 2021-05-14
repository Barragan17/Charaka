package com.example.charaka

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.charaka.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFont()

        binding.tvSignIn.setOnClickListener {
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun changeFont(){
        val typefaceLight: Typeface = Typeface.createFromAsset(assets, "Poppins-Light.ttf")
        val typefaceBold: Typeface = Typeface.createFromAsset(assets, "Poppins-Bold.ttf")

        binding.textView2.typeface = typefaceBold
        binding.tvUsername.typeface = typefaceLight
        binding.tvEmail.typeface = typefaceLight
        binding.tvPassword.typeface = typefaceLight
        binding.tvConfirmPassword.typeface = typefaceLight
        binding.tvToSignIn.typeface = typefaceLight
        binding.tvSignIn.typeface = typefaceLight
        binding.btnSignUp.typeface = typefaceBold
    }
}