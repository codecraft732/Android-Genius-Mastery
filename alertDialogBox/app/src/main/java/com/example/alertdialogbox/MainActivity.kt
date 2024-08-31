package com.example.alertdialogbox

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AlertDialogLayout
import com.example.alertdialogbox.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    //Activity main binding which is our class
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initialize late init binding variable
       binding=ActivityMainBinding.inflate(layoutInflater)
        //address layout file when we use find view by id so we r.id.idname same as it is binding.root address of layout file
        setContentView(binding.root)
        //what action perform to click on button1
         binding.button.setOnClickListener {
             //create alert dialogue variable and open dialog  AlertDialog.Builder(this)
             val builder1=AlertDialog.Builder(this)
             //what is in dialog box settitle massege icon positive negitive button
             builder1.setTitle("are u sure")
             builder1.setMessage("Do you want to close the app?")
             builder1.setIcon(R.drawable.baseline_exit_to_app_24)
             builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                 //what action should be performed when yes is clicked if user click yes then app is closed
             finish()

                 })

             builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                         // if user click no then app is not closed what action should be performed when no is click
                     })
                 builder1.show()//xml screen means app is showing
             }

        binding.button2.setOnClickListener {
            //create a array options
            val options= arrayOf("DairyMilk","Paradise","kitkat")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("which is your favourite chocolate?")
            //single choice item means choose 1 option  (0)this 0 means when dialog box open first one box is already checked
            //dialog interface means option which is present in dialog after click on any single option choose then show a toast massege
     builder2.setSingleChoiceItems(options,0, DialogInterface.OnClickListener { dialog, which ->
         //what action should perform when user click on any option
         Toast.makeText(this, "u clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
     })

            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked
            })

            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when no is click
            })
            builder2.show()
        }


        binding.button3.setOnClickListener {
            val options= arrayOf("DairyMilk","Paradise","kitkat")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("which is your favourite chocolate?")
            //multi choice item means choose multiple options  (null)this null means when dialog box open no one box is already checked
            builder2.setMultiChoiceItems(options,null, DialogInterface.OnMultiChoiceClickListener(){dialog, which , isChecked ->
                    //what action should perform when user click on any option
                    Toast.makeText(this, "u clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
                })

            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked
            })

            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when no is click
            })
            builder2.show()
        }
    }}