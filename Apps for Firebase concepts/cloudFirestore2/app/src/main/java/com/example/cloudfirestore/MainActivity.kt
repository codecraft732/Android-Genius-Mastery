package com.example.cloudfirestore

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.google.firebase.firestore.FirebaseFirestore
//store data in firebase cloud firestore
class MainActivity : AppCompatActivity() {
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnRead=findViewById<Button>(R.id.Read)
        btnRead.setOnClickListener {
            val intent=Intent(this, AccessData::class.java)
            startActivity(intent)
        }
        firestore = FirebaseFirestore.getInstance()

        val nameEditText = findViewById<EditText>(R.id.tVMail)
        val ageEditText = findViewById<EditText>(R.id.tVPassword)
        val addButton = findViewById<Button>(R.id.add)

        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString()

            if (name.isNotEmpty() && age.isNotEmpty()) {
                val user = hashMapOf(
                    "name" to name,
                    "age" to age
                )

                firestore.collection("users") // Choose your collection name
                    .add(user).addOnSuccessListener { documentReference ->
                        Toast.makeText(this, "Data added successfully with ID: ${documentReference.id}", Toast.LENGTH_SHORT).show()
                        // Clear input fields after successful addition
                        nameEditText.text.clear()
                        ageEditText.text.clear()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Error adding data: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "Please enter both name and age", Toast.LENGTH_SHORT).show()
            }

        }
    }
}