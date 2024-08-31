package com.example.fullyfunctional_app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
      val textViewIntent =findViewById<TextView>(R.id.tV1)
        textViewIntent.setOnClickListener {
            intent =Intent(applicationContext, activity_third::class.java)
            startActivity(intent)
        }
        val textView2Intent =findViewById<TextView>(R.id.tV2)
        textView2Intent.setOnClickListener {
            intent =Intent(applicationContext, activity_four::class.java)
            startActivity(intent)
        }
        val textView3Intent =findViewById<TextView>(R.id.tV3)
        textView3Intent.setOnClickListener {
            intent =Intent(applicationContext, activity_fifth::class.java)
            startActivity(intent)
        }
        val textView4Intent =findViewById<TextView>(R.id.tV4)
        textView4Intent.setOnClickListener {
            intent =Intent(applicationContext, activity_sixth::class.java)
            startActivity(intent)
        }
        val textView5Intent =findViewById<TextView>(R.id.tV5)
        textView5Intent.setOnClickListener {
            intent =Intent(applicationContext, activity_seventh::class.java)
            startActivity(intent)
        }
        val textView6Intent =findViewById<TextView>(R.id.tV6)
        textView6Intent.setOnClickListener {
            intent =Intent(applicationContext, activity_eight::class.java)
            startActivity(intent)
        }


        val btnIntent =findViewById<Button>(R.id.callButton)
       btnIntent.setOnClickListener {
           val phoneNumber= "076543456789"
             val intent=Intent(Intent.ACTION_DIAL).apply {
                data= Uri.parse("tel:$phoneNumber")
             }
           startActivity(intent)

    }}
}