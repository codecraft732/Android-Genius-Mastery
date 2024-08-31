package com.example.day24recyclerview

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.News
import com.example.recyclerview.R
import com.google.android.material.imageview.ShapeableImageView

//myAdapter give error put your arrow on this press alt+enter then click implement members
//then view holder alt+enter click implement members ok then class my view holder :

//class two var data or context which context main screen
//recyclerview. adapter basically extended by my adapter
//view holder is very imp adapter's sub class which hold views very imp
//this <my adapter.view holder>create view holder class below
class MyAdapter(var newsArrayList: ArrayList<News>,var context: Activity): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    //create a myListener variable which type is interface onItemClickListener
    private lateinit var myListener: onItemClickListener

    //interface is class which have one var or two fun or one fun is empty so when other class try
    // to implement interface class data mean var or func so it assign some view in empty function
    interface onItemClickListener{
    fun onItemClicking(position: Int)
    }

    //create a fun pass parameter or parameter is interface type
    //this method call in main activity
    fun setOnItemClickListener(listener: onItemClickListener){
        //now here initialize lateinit my listener
        myListener=listener
    }

    //3 methods of  recycler view adapter
    // to create new view instance
    // when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
//to find every item view
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    // populate items with data put data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.hTitle.text = currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)
    }

    // how many list items are present in your array
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    //view holder very imp without it if view holder not hold views or not present
    // its also like list view bad performance
    // it holds the view so views are not created everytime, so memory can be saved
    //my view holder extend recycler view .view holder pass parameter item view which type is :view
    class MyViewHolder(itemView:View,listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        val hTitle =itemView.findViewById<TextView>(R.id.hT)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.hI)


        init{
            itemView.setOnClickListener {
                //on item click come from above *interface
            listener.onItemClicking(adapterPosition)
            }
        }
    }
}


