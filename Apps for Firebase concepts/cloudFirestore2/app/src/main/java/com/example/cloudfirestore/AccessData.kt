package com.example.cloudfirestore

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
//cloud firestore read access retrive data in my app
data class User(val name: String? = null, val age: String? = null)

class AccessData: AppCompatActivity() {
    private lateinit var firestore: FirebaseFirestore
    private lateinit var listView: ListView
    private lateinit var dataList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_access_data)

        firestore = FirebaseFirestore.getInstance()
        listView = findViewById(R.id.listView) // Replace with your ListView's ID
        dataList = ArrayList()

        retrieveData()
    }

    private fun retrieveData() {firestore.collection("users") // Replace with your collection name
        .get()
        .addOnSuccessListener { querySnapshot ->
            dataList.clear()
            for (document in querySnapshot.documents) {
                val user = document.toObject(User::class.java)
                if (user != null) {
                    dataList.add("Name: ${user.name}, Age: ${user.age}")
                }
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
            listView.adapter = adapter
        }
        .addOnFailureListener { exception ->
            Toast.makeText(this, "Error getting documents: ${exception.message}", Toast.LENGTH_SHORT).show()
        }
    }
}