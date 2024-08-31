package com.example.registrationapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
class SignInActivity : AppCompatActivity() {
 private lateinit var databaseReference: DatabaseReference
companion object{//it create in class not function
const val KEY1="com.example.registrationapp.SignIn_activity.name"
const val KEY2="com.example.registrationapp.SignIn_activity.mail"
const val KEY3="com.example.registrationapp.SignIn_activity.id"
}
override fun onCreate(savedInstanceState: Bundle?) {
 super.onCreate(savedInstanceState)
 setContentView(R.layout.activity_sign_in)
val  buttonSignIn=findViewById<Button>(R.id.btnSignIn)
 val userName=findViewById<TextInputEditText>(R.id.tVUniqueId)
buttonSignIn.setOnClickListener{
//userName.text means that particular id in sign in screen
    // where user enter if it id not empty if user enter id name
 // then call read data method if empty user not enter name then show a message enter name
val uniqueId=userName.text.toString()
if(uniqueId.isNotEmpty()){
 readData(uniqueId)
 }else{
 Toast.makeText(this, " please enter user name ", Toast.LENGTH_SHORT).show()
  } } }
    // get id from user .get if id exist then show a
    private fun readData(uniqueId:String){
        databaseReference=FirebaseDatabase.getInstance().getReference("users")
//this lines means address of database users file where all users data save
        databaseReference.child(uniqueId).get().addOnSuccessListener{//.get means unique id exist or not
//then ask from users that your child have that unique id which one user entered exist or not
// if it means unique id exist then
            if (it.exists()){//welcome user in your app,with intent and also pass
//users have child user id's but every particular id have 3 childs
 // if name have in this child then its value(name)        same as mail or id if have then its info show
 val name =it.child("name").value
val mail=it.child("mail").value
val userId=it.child("userid").value
//start intent go to the welcome activity through intent and pass users data
val intentWelcome= Intent(this, WelcomeActivity::class.java)
 //if exist data pass to the welcome activity through intent
intentWelcome.putExtra(KEY1, name.toString())
  intentWelcome.putExtra(KEY2, mail.toString())
 intentWelcome.putExtra(KEY3, userId.toString())
 startActivity(intentWelcome)
 }else{
Toast.makeText(this, "user does not exist ", Toast.LENGTH_SHORT).show()
}
 }.addOnFailureListener { //if not exist id then show this toast
 Toast.makeText(this, "Failed Error in Database", Toast.LENGTH_SHORT).show() }
    }
}