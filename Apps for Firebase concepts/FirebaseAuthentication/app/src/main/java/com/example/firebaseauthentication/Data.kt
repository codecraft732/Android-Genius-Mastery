package com.example.firebaseauthentication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Data : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data)

        val add = findViewById<Button>(R.id.btnAdd)
        val tVName = findViewById<EditText>(R.id.tVName)
        val tVAge = findViewById<EditText>(R.id.tVAge)

        databaseReference = FirebaseDatabase.getInstance().getReference("users")

        add.setOnClickListener {
            val name = tVName.text.toString()
            val age = tVAge.text.toString()

            if (name.isBlank() || age.isBlank()) {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = Dataadd(name, age)

            // Add user data to the database
            //push keyword very imp it automatically generates id's
            databaseReference.push().setValue(user).addOnSuccessListener {
                    // Data added successfully
                    Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show()
                    tVName.text.clear()
                    tVAge.text.clear()
                }
                .addOnFailureListener {
                    // Failed to add data
                    Toast.makeText(this, "Failed to add data", Toast.LENGTH_SHORT).show()
                }
        }
    }
}