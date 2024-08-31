package com.example.api

import MyData
import retrofit2.Call
import retrofit2.http.GET

//retrofit rule for using retrofit create interface
interface ApiInterface {
    //end point url ka last word which url api which u paste in gson kotlin
    @GET("products")
    //when u write call select retrofit
    fun getProductData():Call<MyData>
}