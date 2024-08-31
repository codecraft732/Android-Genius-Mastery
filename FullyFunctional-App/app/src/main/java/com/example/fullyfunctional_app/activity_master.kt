package com.example.fullyfunctional_app
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_master : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_master)

        val btnIntent= findViewById<Button>(R.id.button)
        btnIntent.setOnClickListener{
            intent= Intent(applicationContext, activity_second::class.java)
            startActivity(intent)
        }

    }
}
