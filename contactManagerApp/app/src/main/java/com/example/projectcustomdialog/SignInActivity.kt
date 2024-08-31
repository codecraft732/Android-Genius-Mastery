package com.example.projectcustomdialog

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectcustomdialog.databinding.ActivitySignInBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var dataBaseReference : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignIn.setOnClickListener {
            val uniqueId =  binding.userId.text.toString()
            if ( uniqueId.isNotEmpty()){
                readData(uniqueId)
            }else{
                Toast.makeText(this, "Please enter user id",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun readData( uniqueId : String){


        dataBaseReference= FirebaseDatabase.getInstance().getReference("users")

        dataBaseReference.child(uniqueId).get().addOnSuccessListener {
            if(it.exists()){
                val name = it.child("name").value
                val mail =it.child(/* path = */ "mail").value
                val userId =it.child("userId").value
                val password =it.child("password").value

                val signIntent= Intent(this ,AppScreenActivity::class.java )
                startActivity(signIntent)
            }else {
                Toast.makeText(this, "User does not Exit", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed Error in data base",Toast.LENGTH_SHORT).show()
        }
    }
}