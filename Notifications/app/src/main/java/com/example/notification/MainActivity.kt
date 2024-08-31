package com.example.notification

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

//create notification channel
// and its function
// then create notification mabager
// or click button perform notification
// or last intent click notification open app

//in notification your app must be orea 8 above version otherwise don't able to use channel feature

val Channel_ID="ChannelId"
val Channel_NAME="ChannelName"
val notificationId=0

//suppress means we already add permission or we are confident that our app will not be crashed
@SuppressLint("MissingPermission")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        createNotificationChannel()

        //pending intent
        // when user want user see notification or click maybe after comming notification maybe they check one hour two 4 hour or one day later
           val intent =Intent(this , MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE)

        val notification = NotificationCompat.Builder(this, Channel_ID)
            .setContentTitle("App Dev Challenge")
            .setContentText("Congratulations for Be a Part ")
            .setSmallIcon(R.drawable.baseline_insert_emoticon_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()
        val notificationManager=NotificationManagerCompat.from(this)
        val btn =findViewById<Button>(R.id.button)
       /* //if u don't suppress then check self permission
        btn.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this,Manifest.permission.POST_NOTIFICATIONS )!=PackageManager.PERMISSION_GRANTED){
                //if user not Granted post notification so show the Toast if u want to notify imp updates so keep your notification on u are missing imp updates
                //show dialog or toast
            }
            notificationManager.notify(notificationId,notification)
        }*/

        btn.setOnClickListener {
            //it give error that add permission in menifest file    <uses-permission android:name="android.permission.POST_NOTIFICATIONS"/>
            // //this means if permission is added in menifest then call notify otherwise app will be crash or click missing permission
        notificationManager.notify(notificationId,notification)
        }
    }


        private fun createNotificationChannel() {

            //if version more then oreo version then channel is work otherwise not(oreo is 8th version)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                //create a val channel call nitification channel method and apply some action(if notification show then show some discription or bright light
                val channel = NotificationChannel(
                    Channel_ID,
                    Channel_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                    description = " This is my Notification Channel"
                   lightColor = Color.WHITE
                   enableLights(true)
                }

                val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                manager.createNotificationChannel(channel)
            }
        }

}




/*  notifications is basically services
  if we want to create same notification for music app or run
      notification as song play in foreground show pause off buttons or
       also use another app like playing game or song is running thats services which is running in background
     so add must in manifest in menifest file have play main role in services notification apps
     its just a example not exactly depend your app
<uses-permission android:name="android.permission.FOREGROUND_SERVICE"/>
        android:name=".ChannelClass"
    <service android:name=".ServiceExample"/>        */