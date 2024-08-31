package com.example.contentprovider

    import android.Manifest
    import android.annotation.SuppressLint
    import android.content.ContentResolver
    import android.content.pm.PackageManager
    import android.database.Cursor
    import android.net.Uri
    import android.os.Bundle
    import android.provider.ContactsContract
    import android.widget.ArrayAdapter
    import android.widget.ListView
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.app.ActivityCompat
    import androidx.core.content.ContextCompat
    import java.util.ArrayList

    class MainActivity : AppCompatActivity() {
        private lateinit var list: ListView
        private lateinit var listdata: ArrayList<String>

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            list = findViewById(R.id.list)

            listdata = ArrayList()

            fetchContacts()
        }

        @SuppressLint("Range")
        private fun fetchContacts() {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    0
                )
            } else {
                val resolver: ContentResolver = contentResolver
                val uri: Uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                val cursor: Cursor? = resolver.query(uri, null, null, null, null)
                if (cursor != null && cursor.count > 0) {
                    while (cursor.moveToNext()) {
                        val name: String =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                        val number: String =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                        val myContact = "$name\n$number"
                        listdata.add(myContact)
                    }
                    cursor.close() // Close the cursor after use
                }
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,listdata)
                list.adapter = adapter
            }
        }
    }