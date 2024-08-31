package com.example.bottomsheet

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //create a blank fragment which name bottom sheet fragment activity
    //bottom sheet fragment extend bottom sheet dialog fragment change in bottom sheet fragment activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.button2)
      // Replace with your button's ID
        btn.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager, "BottomSheetTag")
        }
    }
}