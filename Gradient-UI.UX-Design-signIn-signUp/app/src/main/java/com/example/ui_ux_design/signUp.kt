package com.example.ui_ux_design

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class signUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.signup)
    }
}
//in xml add text inputLayout
//in input layout add
//  android:helperText="*required"
//        app:helperTextTextColor="@color/grey"