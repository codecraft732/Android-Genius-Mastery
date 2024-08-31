package com.example.projectcustomdialog

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectcustomdialog.databinding.ActivityAppScreenBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AppScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAppScreenBinding
    private  lateinit var dialog : Dialog
    private lateinit var dataBaseReference : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAppScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val userId = binding.tvId.text.toString()
            val number = binding.tvNumber.text.toString()
            val user= User2(userId, number)

            dataBaseReference=FirebaseDatabase.getInstance().getReference("contacts")
            dataBaseReference.child(userId).setValue(user).addOnSuccessListener {
                dialog= Dialog(this).apply {
                    setContentView(R.layout.custom_dialog)
                    findViewById<Button>(R.id.btnOk).setOnClickListener {
                        dismiss()
                    }
                }
                dialog.show()

            }.addOnFailureListener { Toast.makeText(this, "Failed try again",Toast.LENGTH_SHORT).show() }}
    }
}
