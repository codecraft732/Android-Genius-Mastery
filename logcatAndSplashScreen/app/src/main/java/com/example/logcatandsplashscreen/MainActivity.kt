package com.example.logcatandsplashscreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val textView= findViewById<TextView>(R.id.tv)
        Log.i("INFO TAG","this is info tag")
        textView.setOnClickListener {
            val intent=Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}