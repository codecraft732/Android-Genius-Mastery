package com.example.firebaseauthentication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth // Import FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth // Use FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
       val signup=findViewById<Button>(R.id.btnSignUp)
        val tvMailId = findViewById<TextInputEditText>(R.id.tVMail)
        val tvPassword = findViewById<TextInputEditText>(R.id.tVPassword)

        signup.setOnClickListener {
            val mail = tvMailId.text.toString()
            val password = tvPassword.text.toString()

            if (mail.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Create user with email and password using Firebase Authentication
            auth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign up success, update UI with the signed-in user's information
                        tvPassword.text?.clear()
                        tvMailId.text?.clear()
                        Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show()
                    } else {
                        // If sign up fails, display a message to the user.
                        Toast.makeText(this, "User Not Registered. Try again.", Toast.LENGTH_SHORT).show() } } }

        val signIn = findViewById<TextView>(R.id.textSignin)
        signIn.setOnClickListener {
            val signIntent = Intent(this, LogIn::class.java)
            startActivity(signIntent)
        }
    }
}