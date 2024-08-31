package com.example.fragmentsanalogclock

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragmentsanalogclock.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val clock = findViewById<Button>(R.id.btnClock)
        val sheet= findViewById<Button>(R.id.btnResult)
        val logIn=findViewById<Button>(R.id.btnLog)
        clock.setOnClickListener {
            replaceFrameWithFragment(Clock_Fragment())
        }
        sheet.setOnClickListener {
            replaceFrameWithFragment(Result_Fragment())
        }
        logIn.setOnClickListener {
            replaceFrameWithFragment(LoginFragment())
        }
    }
    //this function created from above replace frame with fragment
    private fun replaceFrameWithFragment(frag: Fragment) {
     //create 2 var replace and then commit
     val fragManager=supportFragmentManager
     val fragTransaction=fragManager.beginTransaction()
        fragTransaction.replace(R.id.frameLayout,frag)
        fragTransaction.commit()
    }
}
//what is fragment use multiple screen in same activity
//it enhance your performance & less code

//create 2 resource file in layout clock or result

//create 2 kotlin class:class type for clock or result sheet

//create login fragment from activity

//for button sharp corners create a bg file in drawable
