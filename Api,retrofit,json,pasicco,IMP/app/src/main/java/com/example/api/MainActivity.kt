package com.example.api

import MyData
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        //retrofit third party liberary
        val retrofitBuilder=Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiInterface::class.java)

             //get product data come from api interface
        val retrofitData=retrofitBuilder.getProductData()

            //for callback my data put your cursor inside bracket press (cntrol shift space) then click
             //there are 2 methods in enqueue fun on response or on failure
        retrofitData.enqueue(object : Callback<MyData?> {
            //2parameters call or response we give any name
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                // if api call is a success, then use the data of API and show in your app
                var responseBody = response.body()
                //response body products which have multiple objects see in product file
                //if response body empty so use ? to avoid crashing
                val productList = responseBody?.products!!
                //if (productList != null) don't want to write this line use above !!


                myAdapter = MyAdapter(this@MainActivity, productList)
                //recyclerview set adapter or layout manager
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }
            //my data file which have 4 var  throwble means it tells that why its fail
            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                // if api call fails
                Log.d("Main Activity ", "onFailure: " + t.message)
            }
        })
}}