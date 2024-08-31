package com.example.multiscreenapp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //creating key
    companion object{
        const val KEY="com.example.multiscreenapp.MainActivity.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonOrder=findViewById<Button>(R.id.btnOrder)
        val editText1=findViewById<TextView>(R.id.editText1)
        val editText2=findViewById<TextView>(R.id.editText2)
        val editText3=findViewById<TextView>(R.id.editText3)
        val editText4=findViewById<TextView>(R.id.editText4)
     buttonOrder.setOnClickListener {
         val ordersPlaced= editText1.text.toString()+" "+
                          editText2.text.toString()+" "+
                          editText3.text.toString()+" "+
                          editText4.text.toString()
            intent= Intent(this, order::class.java)
            intent.putExtra(KEY, ordersPlaced)
            startActivity(intent)
      }
    }
}