package com.example.firebaseretriveaccessdata

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
/*two types (add event listener) or (add value for single event listener ) in add event listener when we dlt data from data base
 it also dlt from my app where we access data
 but when we use single its just dlt from data base not from app
 in this app we add event listener when we dlt or add data from firebase if effects on my app also
*/
class MainActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    private lateinit var listView: ListView
    private lateinit var dataList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

                listView = findViewById(R.id.listView)
                dataList = ArrayList()

                databaseReference = FirebaseDatabase.getInstance().getReference("users")
        // Adjust "users" if your data is stored in a different node

                // Retrieve data from Firebase
                databaseReference.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        dataList.clear() // Clear the list before adding new data
                        //no matter how many childs have at the end point get access data
                        for (userSnapshot in snapshot.children) {

                            val user = userSnapshot.getValue(User::class.java) // Assuming your data is stored as strings
                            if (user != null) {
                                dataList.add("Name: ${user.name}, Age: ${user.age}")

                            }
                        }

                        // Update the ListView with the retrieved data
                        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, dataList)
                        listView.adapter = adapter
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle errors
                        Toast.makeText(this@MainActivity, "Failed to retrieve data", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
