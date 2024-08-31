package com.example.listview2
/*in listview1 we have only string data but now in each item list view
 which we create there is multiple data like date name massage image
so we create a kotlin data class*/

data class User(var name:String, var lastMassage:String,
    var lastMassageTime: String, var phoneNumber:String, var imageId:Int)

//R.id.idname its type is ( int ) that's why imageId type int