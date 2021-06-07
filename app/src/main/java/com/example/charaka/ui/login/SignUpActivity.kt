package com.example.charaka.ui.login

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.charaka.R
import com.example.charaka.data.local.entity.User
import com.example.charaka.databinding.ActivitySignUpBinding
import com.example.charaka.ui.home.HomeActivity
import com.example.charaka.utils.Valid
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import es.dmoral.toasty.Toasty

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var auth: FirebaseAuth
    private lateinit var mAuth: DatabaseReference
    private lateinit var binding: ActivitySignUpBinding

    private var inputName: String? = null
    private var inputUsername: String? = null

    private var name: EditText? = null
    private var usernameEditText: EditText? = null
    private var emailEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var confirmPasswordEditText: EditText? = null

    private var signUpBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }

        auth = FirebaseAuth.getInstance()
        mAuth = FirebaseDatabase.getInstance().getReference("users")

        // widget pairing...
        name = findViewById(R.id.et_name)
        usernameEditText = findViewById(R.id.et_username)
        emailEditText = findViewById(R.id.et_email)
        passwordEditText = findViewById(R.id.et_password)
        confirmPasswordEditText = findViewById(R.id.et_confirm_password)
        signUpBtn = findViewById(R.id.btn_sign_up)

        signUpBtn!!.setOnClickListener(this)
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

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_sign_up -> {

                inputName = name?.text.toString().trim()
                inputUsername = usernameEditText?.text.toString().trim()
                val inputEmail = emailEditText?.text.toString().trim()
                val inputPassword = passwordEditText?.text.toString().trim()
                val inputConfirmPassword = confirmPasswordEditText?.text.toString().trim()

                if (!inputName.isNullOrBlank() && !inputUsername.isNullOrBlank() && !inputEmail.isNullOrBlank() && !inputPassword.isNullOrBlank() && !inputConfirmPassword.isNullOrBlank()) {

                    if(Valid.isValidEmail(inputEmail)){
                        if (inputPassword.equals(inputConfirmPassword)) {
                            signUpBtn?.setText("Wait")
                            signUpBtn?.setEnabled(false)

                            // check if already exists?
                            mAuth.orderByChild("email").equalTo(inputEmail).addListenerForSingleValueEvent(object :
                                ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {

                                    var userEmail : String? = null

                                    for (userSnapshot in dataSnapshot.children) {
                                        val user = userSnapshot.getValue(User::class.java)
                                        userEmail = user!!.email

                                        if(inputEmail == userEmail){
                                            break
                                        }
                                    }

                                    // no match to existing users
                                    if(userEmail == null) {
                                        val user = User(
                                            (0..100).random().toString(),
                                            inputName!!,
                                            inputUsername!!,
                                            inputEmail,
                                            inputPassword
                                        )
                                        var userRef = mAuth.push()
                                        mAuth.child(userRef.key.toString()).setValue(user, object : DatabaseReference.CompletionListener {
                                            override fun onComplete(p0: DatabaseError?, p1: DatabaseReference) {

                                                signUpBtn?.setText(R.string.sign_up)
                                                signUpBtn?.setEnabled(true)

                                                if (p0 != null) {
                                                    Toast.makeText(this@SignUpActivity, p0.message, Toast.LENGTH_SHORT).show()
                                                } else {
                                                    registerUser(inputEmail, inputPassword)
                                                }
                                            }
                                        })
                                    }else{
                                        if(signUpBtn?.isEnabled == false){
                                            Toast.makeText(
                                                this@SignUpActivity,
                                                "Email address is not available.",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    }

                                    signUpBtn?.setText(R.string.sign_up)
                                    signUpBtn?.setEnabled(true)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    // Getting user failed
                                    val builder = AlertDialog.Builder(this@SignUpActivity)
                                    builder.setTitle(android.R.string.dialog_alert_title)
                                    builder.setMessage(databaseError.message)
                                    builder.setPositiveButton(android.R.string.ok) { dialog, which ->
                                        Toast.makeText(this@SignUpActivity,
                                            android.R.string.yes, Toast.LENGTH_SHORT).show()
                                    }
                                    builder.show()

                                    signUpBtn?.setText(R.string.sign_up)
                                    signUpBtn?.setEnabled(true)
                                }
                            })
                        } else {
                            Toast.makeText(
                                this@SignUpActivity,
                                "Confirm password and password do not match.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }else{
                        Toast.makeText(
                            this@SignUpActivity,
                            "Invalid email address.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                } else {
                    Toast.makeText(this@SignUpActivity, "All input values are reguired!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        changeFont()
    }

    private fun registerUser(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    signUpBtn?.setText(R.string.sign_up)
                    signUpBtn?.setEnabled(true)
                    val builder = AlertDialog.Builder(this@SignUpActivity)
                    builder.setTitle(android.R.string.dialog_alert_title)
                    builder.setMessage(R.string.sign_up_success)
                    builder.setPositiveButton(R.string.sign_in_now) { dialog, which ->
                        val intent = Intent(this@SignUpActivity, HomeActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                    builder.show()
                } else {
                    Toasty.error(this, it.exception?.message.toString(), Toast.LENGTH_SHORT).show()
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