package com.example.multiscreenapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)
        val tvOrder=findViewById<TextView>(R.id.tVOrder)
        val ordersOfCustomer=intent.getStringExtra(MainActivity.KEY)
        tvOrder.text ="orderPlaced \n"+ ordersOfCustomer.toString()
    }
}