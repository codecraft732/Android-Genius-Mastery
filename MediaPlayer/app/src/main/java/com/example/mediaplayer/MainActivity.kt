package com.example.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.xml.sax.HandlerBase


class MainActivity : AppCompatActivity() {

    lateinit var mediaPlayer: MediaPlayer
    var totalTime:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val btnPlay=findViewById<ImageView>(R.id.imageView3)
        val btnPause=findViewById<ImageView>(R.id.imageView2)
        val btnStop=findViewById<ImageView>(R.id.imageView4)
        val seekBarMusic=findViewById<SeekBar>(R.id.seekBar)

        mediaPlayer=MediaPlayer.create(this,R.raw.music)
            //if we want to use loop in our media player app use this piece of code *//mediaPlayer.isLooping=true*
        mediaPlayer.setVolume(1f , 1f)
            totalTime=mediaPlayer.duration

                    btnPause.setOnClickListener{ mediaPlayer.pause() }
                    btnPlay.setOnClickListener{ mediaPlayer.start() }
                    btnStop.setOnClickListener{ mediaPlayer.stop()
                        mediaPlayer.reset()
                        mediaPlayer.release() }

            //when user changes the time stamp music,reflect that changes
            seekBarMusic.max=totalTime
            //create a seekbar method for change
            seekBarMusic.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
                //if user change seekbar so call media player
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    //call media player according to user change in which timestamp user change the seekbar play that timestamp music
                    if(fromUser){
                        mediaPlayer.seekTo(progress)
                    }
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })



       //change  the seekbar position based on music when music play it goes to so seekbar position also goes through with the comparison of music
      //handler alternative android learn more from google article
        val handler= Handler()
        handler.postDelayed(object:Runnable{
            override fun run() {
                //if in this two lines of code we try or its not run smoothly something went wrong so we don't want to crash our app
                // we want to catch so use try catch for exception handling
                try {
                    seekBarMusic.progress = mediaPlayer.currentPosition
                    handler.postDelayed(this, 1000)
                }catch(exception:java.lang.Exception){
                    seekBarMusic.progress=0

                }
            }
                   },0)
                    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}