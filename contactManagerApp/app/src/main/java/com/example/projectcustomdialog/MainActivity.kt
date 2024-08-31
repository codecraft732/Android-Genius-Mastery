package com.example.projectcustomdialog

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.projectcustomdialog.databinding.ActivityMainBinding
//check gradle firebase dependency
//check gradle binding view syn or add(in binding view concept every activity have their own names not copy paste )
//in manifest check internet permission
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed({
            val intent =Intent(this , SignUpActivity::class.java)
            startActivity(intent)
        },2000)
    }
}








