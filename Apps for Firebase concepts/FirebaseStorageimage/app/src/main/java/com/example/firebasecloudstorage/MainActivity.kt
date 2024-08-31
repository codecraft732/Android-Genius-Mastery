package com.example.firebasecloudstorage

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

//when we click on upload our gallery open and we have upload images
// or when we click save image save in firebase cloud storage
//its also use for image audio vedio storage

class MainActivity : AppCompatActivity() {

    private lateinit var btnSave: Button
    private lateinit var btnUpload: Button
    private lateinit var image: ImageView
    private lateinit var storageRef: StorageReference
    private var imageUri: Uri? = null

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnSave =findViewById(R.id.save)
        btnUpload = findViewById(R.id.upload)
        image = findViewById(R.id.imageView)

        storageRef = FirebaseStorage.getInstance().reference.child("images") // Change "images" to your desired storage folder

        btnSave.isEnabled = false

        btnUpload.setOnClickListener {
            openGallery()
        }

        btnSave.setOnClickListener {
            uploadImage()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            imageUri = data.data
            image.setImageURI(imageUri) // Set selected image to ImageView
            btnSave.isEnabled = true // Enable save button after image is selected
        }
    }private fun uploadImage() {
        imageUri?.let {
            Toast.makeText(this, "Uploading image...", Toast.LENGTH_SHORT).show()

            val imageRef = storageRef.child(System.currentTimeMillis().toString() + ".jpg") // Generate unique file name
            val uploadTask = imageRef.putFile(it)

            uploadTask.addOnSuccessListener {
                Toast.makeText(this, "Image uploaded successfully", Toast.LENGTH_SHORT).show()
                btnSave.isEnabled = false // Disable save button after upload
            }.addOnFailureListener { exception ->
                Toast.makeText(this, "Upload failed: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
        } ?: run {
            Toast.makeText(this, "Please select an image first", Toast.LENGTH_SHORT).show()
        }
    }
}























