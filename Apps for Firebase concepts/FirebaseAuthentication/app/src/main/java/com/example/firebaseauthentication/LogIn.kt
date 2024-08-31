package com.example.firebaseauthentication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth // Import FirebaseAuth

class LogIn : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth // Use FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_log_in)

        auth = FirebaseAuth.getInstance() // Initialize FirebaseAuth

        val buttonSignIn= findViewById<Button>(R.id.btnLogIn)
        val tvMailId = findViewById<TextInputEditText>(R.id.tVMail)
        val tvPassword = findViewById<TextInputEditText>(R.id.tVPassword)

        buttonSignIn.setOnClickListener {
            val email = tvMailId.text.toString()
            val pass = tvPassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                signInWithEmailAndPassword(email, pass)
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signInWithEmailAndPassword(email: String, pass: String) {
        // Sign in using Firebase Authentication
        auth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val intentWelcome= Intent(this, Data::class.java)
                    startActivity(intentWelcome)}else{
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                }
            }
    }
}