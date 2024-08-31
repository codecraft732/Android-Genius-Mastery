package com.example.registrationapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val name=intent.getStringExtra(SignInActivity.KEY1)
        val mail=intent.getStringExtra(SignInActivity.KEY2)
        val userId=intent.getStringExtra(SignInActivity.KEY3)
        val welcomeText=findViewById<TextView>(R.id.tV1)
        val mailText=findViewById<TextView>(R.id.tmail)
        val idText=findViewById<TextView>(R.id.tid)
        welcomeText.text="Welcome : $name"
        mailText.text="Mail : $mail"
        idText.text="userId :$userId"

    }
}