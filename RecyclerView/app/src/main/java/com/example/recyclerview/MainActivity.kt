package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.day24recyclerview.MyAdapter

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    //for data mostly use arraylist here for new data
    lateinit var newsArrayList:ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//initialize recycler view above we mention initialize it later
        myRecyclerView=findViewById(R.id.rV1)
//set data through array
        val newsImageArray= arrayOf(
                    R.drawable.img1,
                    R.drawable.img2,
                    R.drawable.img3,
                    R.drawable.img4,
                    R.drawable.img5,
                    R.drawable.img6
        )
            val newsHeadingArray=arrayOf(
                "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
                "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
                "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
                "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
                "Belarusian leader Lukashenko visits China amid Ukraine tensions",
                "China rips new U.S. House committee on countering Beijing",
                "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra"
            )
        /*
        val newsContent = arrayOf(
            getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content)
        )*/
        val newsContent = arrayOf(
            getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content)
        )

        // to set of items inside recyclerview, vertcially scrolling, horizontally, uniform grid
        //how items move
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()
//with the help of for loop news set with sequence create 6 obj <image 0 heading0> <image 1 heading1>like this
        for( index in newsImageArray.indices){
            val news = News(newsHeadingArray[index], newsImageArray[index] , newsContent[index])
            newsArrayList.add(news)
        }
//set adapter
        val myAdapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter

        //interface class invite from adapter through object
        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClicking(position: Int) {
                // on clicking each item , what action do you want to perform
//if intent (this) give error so pass applicationContext otherwise
                val intent = Intent(this@MainActivity, NewsDetailActivity::class.java)
                intent.putExtra("heading", newsArrayList[position].newsHeading)
                intent.putExtra("imageId", newsArrayList[position].newsImage)
                intent.putExtra("newscontent", newsArrayList[position].newsContent)
                startActivity(intent)
            }

        })

    }
}