package com.example.charaka.ui.login

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.charaka.R
import com.example.charaka.data.local.entity.User
import com.example.charaka.databinding.ActivitySignInBinding
import com.example.charaka.ui.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class SignInActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var auth: FirebaseAuth
    private lateinit var mAuth: DatabaseReference
    private lateinit var binding: ActivitySignInBinding

    private var usernameEditText : EditText? = null
    private var passwordEditText : EditText? = null

    private var signInBtn : Button? = null
    private var tvSignUp : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        mAuth = FirebaseDatabase.getInstance().getReference("users")

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvToSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
        // widget pairing...
        usernameEditText = findViewById(R.id.edt_username)
        usernameEditText?.setText(intent.getStringExtra("logged_in_email"))
        passwordEditText = findViewById(R.id.edt_password)
        signInBtn = findViewById(R.id.btn_sign_in)
        tvSignUp = findViewById(R.id.tv_to_sign_up)

        signInBtn!!.setOnClickListener(this)
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

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_sign_in -> {

                val inputEmail = usernameEditText?.text.toString().trim()
                val inputPassword = passwordEditText?.text.toString().trim()

                if (!inputEmail.isNullOrBlank() && !inputPassword.isNullOrBlank()) {

                    signInBtn?.setText("Wait")
                    signInBtn?.setEnabled(false)

                    mAuth.orderByChild("email").equalTo(inputEmail).addValueEventListener(object :
                        ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            var isLoginMatch: Boolean? = false
                            var userUsername: String? = null
                            var userEmail: String? = null
                            var userPassword: String? = null
                            var userExtra: User? = null

                            for (userSnapshot in dataSnapshot.children) {
                                val user = userSnapshot.getValue(User::class.java)
                                Log.d("USER", "$user")

                                userUsername = user!!.username
                                userEmail = user!!.email
                                userPassword = user!!.password
                                userExtra = user

                                if (userPassword == inputPassword) {
                                    isLoginMatch = true
                                    break
                                }
                            }

                            if (isLoginMatch == true) {
                                loginUser(inputEmail, inputPassword)
                            } else {
                                val builder = AlertDialog.Builder(this@SignInActivity)
                                builder.setTitle(android.R.string.dialog_alert_title)
                                builder.setMessage(R.string.invalid_login_message)
                                builder.setPositiveButton(android.R.string.ok) { dialog, which ->
                                    dialog.dismiss()
                                }
                                builder.show()
                            }

                            signInBtn?.setText(R.string.sign_in)
                            signInBtn?.setEnabled(true)
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            // Getting user failed
                            val builder = AlertDialog.Builder(this@SignInActivity)
                            builder.setTitle(android.R.string.dialog_alert_title)
                            builder.setMessage(databaseError.message)
                            builder.setPositiveButton(android.R.string.ok) { dialog, which ->
                                Toast.makeText(
                                    this@SignInActivity,
                                    android.R.string.yes, Toast.LENGTH_SHORT
                                ).show()
                            }
                            builder.show()

                            signInBtn?.setText(R.string.sign_in)
                            signInBtn?.setEnabled(true)
                        }
                    })
                } else {
                    Toast.makeText(
                        this@SignInActivity,
                        "Email or Password cannot be empty!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        changeFont()
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Intent(this@SignInActivity, HomeActivity::class.java).also { intent ->
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        }
                    }else {
                        Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
    }

    override fun onStart() {
        super.onStart()
        if(auth.currentUser != null){
            Intent(this, HomeActivity::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
    }
}