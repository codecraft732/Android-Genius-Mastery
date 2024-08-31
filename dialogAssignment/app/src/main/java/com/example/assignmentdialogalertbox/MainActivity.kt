package com.example.assignmentdialogalertbox

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentdialogalertbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button4.setOnClickListener {
            val builder4 = AlertDialog.Builder(this)
            builder4.setTitle("Are u sure.")
            builder4.setMessage("Do you really want to close the app?")
            builder4.setIcon(R.drawable.baseline_exit_to_app_24)
            builder4.setPositiveButton(
                "yes",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    finish()
                })
            builder4.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
            })
            builder4.show()
        }

        binding.button.setOnClickListener {
            val choose = arrayOf("Software Engineering", "MakeupArtist", "Nursing")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which one option is related to tech field?")
            builder2.setSingleChoiceItems(choose, 0, DialogInterface.OnClickListener(){ dialog, which ->
                    Toast.makeText(this, "u clicked on ${choose[which]}", Toast.LENGTH_SHORT).show()
                })

            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i -> })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i -> })
            builder2.show()
        }

        binding.button2.setOnClickListener {
            val options = arrayOf("An Engineer", "A Doctor", " A GraphicDesigner","A DataAnalyst")
         val builder3 = AlertDialog.Builder(this)
        builder3.setTitle("Professionally, what are you?")
        builder3.setMultiChoiceItems(options, null , DialogInterface.OnMultiChoiceClickListener(){ dialog, which , isChecked->
                Toast.makeText(this, "u clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })

        builder3.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i -> })
        builder3.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i -> })
        builder3.show()
    }
           }
    }
