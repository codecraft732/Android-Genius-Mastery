package com.example.viewbinding

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //first we add feature in gradle build .kt module app and sync
    // pick this feature from (view binding android ) article mostly (stackoverflow articles)
    // this feature automatically create a binding class for all activities e.g activityMainBinding
    //we don't need to write a find view by id view binding concise your code
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//now we need to initialize binding var when we use view binding this piece of line code is always same
        binding = ActivityMainBinding.inflate(layoutInflater)
        //  setContentView(R.layout.activity_main) we pass r.id.id name but now we just pass binding variable
        // binding.root is the address of xml file
        setContentView(binding.root)
        binding.button.setOnClickListener {
            if (binding.checkBox.isChecked) {
                //open a new screen

            } else {
                binding.checkBox.buttonTintList = ColorStateList.valueOf(Color.RED)
                Toast.makeText(this, "please accept terms & conditions", Toast.LENGTH_SHORT).show()
            }
        }
    }}





