package com.example.registrationapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
            // var database:(its a datatype like string float that how its a database reference)DatabaseReference
            // (basically it give error because it want to initialise this value here
            // so we use here late init keyword  (means we create variable now but late init(initialize later))
            lateinit var dataBaseReference: DatabaseReference
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                val signup=findViewById<Button>(R.id.btnSignUp)
                val tvMailId=findViewById<TextInputEditText>(R.id.tVMail)
            //edit text we mention id in text input edit text not text input layout
            // if we add id in text input layout in xml file
            // then we shall use here text input layout instead of text input edit text
                val tvName=findViewById<TextInputEditText>(R.id.tVName)
                val tvPassword=findViewById<TextInputEditText>(R.id.tVPassword)
                val tvUserId=findViewById<TextInputEditText>(R.id.tVUniqueId)
                signup.setOnClickListener {
                    val mail= tvMailId.text.toString()
                    val name=tvName.text.toString()
                    val uniqueId= tvUserId.text.toString()
                    val password=tvPassword.text.toString()
             // setOnClickListener means when user click this button so that particular
             // 4 user information is store in database file)

                    // Input Validation: Check if any field is empty
                    if (mail.isBlank() || name.isBlank() || uniqueId.isBlank() || password.isBlank()) {
                        Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener // Stop execution if any field is empty
                    }


                    //now enter data into firebase create a user object
                    val user=User(name, mail, password, uniqueId)
                    dataBaseReference=FirebaseDatabase.getInstance().getReference("users")
                    //database which create above variable and declare that we initialise it later (late init)
                    // (here we initialize this )database=FirebaseDatabase.getInstance().getReference("users")
                    //  ( this piece of code basically represent the database file in firebase where we save our users data
                    //  means it tells us firebase file address where users data will be store)
                    //data recognise with unique id all other user data show in unique id
                    //addONSuccessListener means when  user registered successfully so show toast message
                    dataBaseReference.child(uniqueId).setValue(user).addOnSuccessListener {
                        //.setValue create user object which is user name mail pass unique id
                        tvName.text?.clear()//(this means after register previous detail clear enter the name show as it is)
                        tvUserId.text?.clear()
                        tvPassword.text?.clear()
                        tvMailId.text?.clear()
                        Toast.makeText(this,"User Registered Successfully", Toast.LENGTH_SHORT).show()}.addOnFailureListener {
                        Toast.makeText(this, "User Not Registered Try again", Toast.LENGTH_SHORT).show()
                    }


                        //when button signup click so in database make a userdata like parent class or
                        // inside this class user details pass or name
                }
                val signIn=findViewById<TextView>(R.id.textSignin)
                signIn.setOnClickListener {
                    val signIntent= Intent(this,SignInActivity::class.java)
                    startActivity(signIntent)
                }
            }

    }