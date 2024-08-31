package com.example.listview2

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
//user array list type user which we create in data class
  lateinit var userArrayList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val name = arrayOf("Alishba","Rabia","Maryam","Zoha")
        val lastMassage= arrayOf("hey listen","why?","maybe ","acha ok")
        val lastMassageTime= arrayOf("4:45 PM","11:00 AM","1:30 PM","5:00 AM")
        val phoneNumber= arrayOf("03039876556","0987654347","09876543210","03456789012")
        val imageId = intArrayOf(R.drawable.pic4,R.drawable.pic3,R.drawable.pic2,R.drawable.pic1)

        userArrayList= ArrayList()
       // now we are using for loop
        for(eachIndex in name.indices){
    //in array every index start with 0 first user 0 index's details get from all objects
            // e.g first name number time or msg
            val user=User(name[eachIndex] ,lastMassage[eachIndex] ,lastMassageTime[eachIndex],
                phoneNumber[eachIndex], imageId[eachIndex])
            userArrayList.add(user)
        }
        val listView=findViewById<ListView>(R.id.listView)
        listView.isClickable=true
        //through adapter we make connection between data and layout
        //now create a new kotlin class which is not data type class which type is class
        //make our own adapter through kotlin class file
        listView.adapter=  MyAdapter(this, userArrayList)

listView.setOnItemClickListener {parent, view,position, id ->
    val userName= name[position]
    val userPhone =phoneNumber[position]
    val image=imageId[position]
    val intent=Intent(this , UserActivity::class.java)
    intent.putExtra("imageId", image)
    intent.putExtra("name",userName)
    intent.putExtra("phoneNumber", userPhone)
    startActivity(intent)
} }
    }
/*each item xml
 we want to show circle image view we use third party dependency for circle image view
 search in google
 circle image view hdon android
and copy dependency from there and add in (gradle build .kt module app)

 */