package com.example.projectcustomdialog

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectcustomdialog.databinding.ActivitySignUpBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase



class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var dataBaseReference : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignup.setOnClickListener {
            val name = binding.tvname.text.toString()
            val email = binding.tvemail.text.toString()
            val uniqueId =  binding.tvuserid.text.toString()
            val password=binding.tvpass.text.toString()
            if ( name.isBlank() || email.isBlank() || uniqueId.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Stop execution if any field is empty
            }

            val user = User(name, email, uniqueId, password)
            dataBaseReference= FirebaseDatabase.getInstance().getReference("users")
            dataBaseReference.child(uniqueId).setValue(user).addOnSuccessListener {

                Toast.makeText(this, "User Registered Successfully",Toast.LENGTH_SHORT).show()
                    binding.tvname.text?.clear()//(this means after register previous detail clear enter the name show as it is)
                    binding.tvuserid.text?.clear()
                    binding.tvemail.text?.clear()
                    binding.tvpass.text?.clear()

            }.addOnFailureListener { Toast.makeText(this, "Failed try again",Toast.LENGTH_SHORT).show() }
        }
        binding.tvsignin.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}