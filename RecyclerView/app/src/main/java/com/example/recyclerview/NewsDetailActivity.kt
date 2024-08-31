package com.example.recyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_detail2)

        val heading = intent.getStringExtra("heading")
        val newsContent = intent.getStringExtra("newscontent")
        val imageId = intent.getIntExtra("imageId", R.drawable.img1)

        val headingTV = findViewById<TextView>(R.id.newsHeading)
        val headingIV = findViewById<ImageView>(R.id.newsImage)
        val newsContentTV = findViewById<TextView>(R.id.newsContent)

        headingTV.text = heading
        newsContentTV.text = newsContent
        headingIV.setImageResource(imageId)
    }
}
