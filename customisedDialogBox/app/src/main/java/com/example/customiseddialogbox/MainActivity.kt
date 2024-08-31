package com.example.customiseddialogbox

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
//dialog is a variable and : Dialog is a type if we are using binding concept so it has its particular type
 //types is not just ( string int boolean or char float) there are N numbers of types multiple concepts has their own particular types
    lateinit var dialog : Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        val buttonClick= findViewById<Button>(R.id.button)
        //late init dialog initialise here
        dialog= Dialog(this)
        //give address which is created by layout resource file not create a new activity
        dialog.setContentView(R.layout.custom_dialog)
        //this piece of line code is for rounded corner shape dialog box
        //and this ? is very imp in kotlin this means
        // if dialog.window null then apps would be crashed so for solving this
        //we add question mark so if then app is not crashed its stop not run the following code
dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))
        val buttonGood = dialog.findViewById<Button>(R.id.button3)
        val buttonFeedBack = dialog.findViewById<Button>(R.id.button4)
        buttonClick.setOnClickListener {
            dialog.show() }
   buttonGood.setOnClickListener{
       dialog.dismiss()
   }
        buttonFeedBack.setOnClickListener {
            Toast.makeText(this, "Feedback Given",Toast.LENGTH_SHORT).show() }
}}