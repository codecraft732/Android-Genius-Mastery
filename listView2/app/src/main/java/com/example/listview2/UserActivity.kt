package com.example.listview2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)
val name =intent.getStringExtra("name")
        val phone=intent.getStringExtra("phoneNumber")
        val imageId=intent.getIntExtra("imageId",R.drawable.pic4)


        val nameTV=findViewById<TextView>(R.id.tVName)
        val userPhone=findViewById<TextView>(R.id.tVNumber)
        val imageTV=findViewById<CircleImageView>(R.id.profile_image)


        nameTV.text= name
        userPhone.text=phone
        imageTV.setImageResource(imageId)
    }
}