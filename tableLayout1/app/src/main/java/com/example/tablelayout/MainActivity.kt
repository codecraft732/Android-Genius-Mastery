package com.example.tablelayout

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.addButton)
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val numberEditText = findViewById<EditText>(R.id.numberEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)




        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val number = numberEditText.text.toString()
            val email = emailEditText.text.toString()

            val tableRow = LayoutInflater.from(this).inflate(R.layout.table_row, null) as TableRow
            tableRow.findViewById<TextView>(R.id.nameTextView).setText(number)
            tableRow.findViewById<TextView>(R.id.numberTextView).setText(name)
            tableRow.findViewById<TextView>(R.id.emailTextView).setText(email)

            val removeButton = tableRow.findViewById<TableRow>(R.id.removeButton)

            removeButton.setOnClickListener {
                tableLayout.removeView(tableRow)
            }

            tableLayout.addView(tableRow)

        }
    }
}

