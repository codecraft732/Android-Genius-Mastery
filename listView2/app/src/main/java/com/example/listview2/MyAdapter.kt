package com.example.listview2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

// in my adapter we give two parameters one from main activity or
// 2nd one adapter extend built in array adapter which we use in last listview project
class MyAdapter(val context:Activity, val arrayList: ArrayList<User>):
ArrayAdapter<User>(context,R.layout.eachitem, arrayList){
    //now override fun ,with the help of this line of code pick each item .xml view circle image text view
    override fun getView(Position:Int , convertView : View?, parent:ViewGroup):View{
//context means main activity  listView.adapter=  MyAdapter(this, userArrayList) this* means context
        // whole main activity code use
        val infalter=LayoutInflater.from(context)
        val view =  infalter.inflate(R.layout.eachitem,null)
//help of view search address of each item
        val image =view.findViewById<CircleImageView>(R.id.profile_image)
        val name =view.findViewById<TextView>(R.id.tVName)
        val lastMassage =view.findViewById<TextView>(R.id.tVLastMassage)
        val lastMassageTime =view.findViewById<TextView>(R.id.tVTimeMassage)
        //now set text what we show
        name.text=arrayList[Position].name
        lastMassage.text=arrayList[Position].lastMassage
        lastMassageTime.text=arrayList[Position].lastMassageTime
        image.setImageResource(arrayList[Position].imageId)
        return view
        }
            }