package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        //list view tasks add with the help of array string
       val taskList=  arrayListOf<String>()
        taskList.add("Eat breakfast")
        taskList.add("Read Book")
        taskList.add("java oops practise")
        taskList.add("Dsa learn")
        taskList.add("Work on resume")

//adapter which makes connection between (data source like array hashtag sqlite) or (list view & any component)
 // for example u have a switch or a phone but how to charge with the help of charger
        //android.R.layout.simple_list_item_1 we can also create it own as we want
 val adapterForMyListView = ArrayAdapter(this , android.R.layout.simple_list_item_1,taskList)
       //.adapter means set adapter which shows your data
        listView.adapter=adapterForMyListView

        //if u want after click items it perform some function
listView.setOnItemClickListener { percent, view, position, id ->
    //every item has its own information every item has different particular data
    // every item has own id view position or percent
    val text = "clicked on item : "+(view as TextView).text.toString()
    Toast.makeText(this , text, Toast.LENGTH_SHORT).show()
    }
     }
        }