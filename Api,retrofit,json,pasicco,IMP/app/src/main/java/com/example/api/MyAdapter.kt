package com.example.api

import Product
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
//product arraylist product file which have list of products
class MyAdapter(val context :Activity,val productArrayList:List<Product>) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }
//populate data inside( ui text view)  <holder.title.text = currentItem.title>
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        // image view , how to show image in image view if the image is in form of url, 3rd Party Library
        // Picasso
        //holder.image come from below shapeable image
        //above variable current item  find position thats why we write current item. thumbnail which is image
        Picasso.get().load(currentItem.thumbnail).into(holder.image);
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var title : TextView
        var image : ShapeableImageView

        init {
            title = itemView.findViewById(R.id.productName)
            image = itemView.findViewById(R.id.productImage)
        }
    }

}