package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
//we don't write code in fragments its written by default u don't need to write code in fragments
//home profile search
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        //it give error for private fun replace with fragment
        replaceWithFragment(Home())
        // by default, home fragment should be visible to the user
        bottomView.setOnItemSelectedListener {
            when(it.itemId){
                //id which we give in items.xml
                R.id.item1 -> replaceWithFragment(Home())
                R.id.item2 -> replaceWithFragment(Search())
                R.id.item3 -> replaceWithFragment(Profile())
                else -> {
                }
            }
            true
        }
    }
    //this fun created by replace with fragment
    //passed fragment parameter which is home above we give
    private fun replaceWithFragment(fragment : Fragment) {
        //call fragment manager
        val fragmentManager = supportFragmentManager
        //for begin transaction
        val fragmentTransaction = fragmentManager.beginTransaction()
        //frame layout replace by fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit() }
    }
