package com.example.entheos

import CustomAdapter_RcV_promo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class promotion_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promotion)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = GridLayoutManager(this,2)


        // ArrayList of class ItemsViewModel
        val data = ArrayList<itemsVIewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        data.add(itemsVIewModel(R.drawable.card_item_teamwork,"Audibling","12-Aug-2020"))
        data.add(itemsVIewModel(R.drawable.card_item_kingscrown,"Tricky","02-April-2001"))
        data.add(itemsVIewModel(R.drawable.card_item_teamwork,"Sourabh","12-Jan-2020"))
        data.add(itemsVIewModel(R.drawable.card_item_kingscrown,"dhaval","02-Jun-2001"))
        data.add(itemsVIewModel(R.drawable.card_item_teamwork,"sumit","12-Jul-2020"))
        data.add(itemsVIewModel(R.drawable.card_item_kingscrown,"shivam","02-Sep-2001"))
        data.add(itemsVIewModel(R.drawable.card_item_teamwork,"harsh","12-Oct-2020"))
        data.add(itemsVIewModel(R.drawable.card_item_kingscrown,"raunak","02-May-2001"))
        data.add(itemsVIewModel(R.drawable.card_item_teamwork,"vishal","12-Nov-2020"))
        data.add(itemsVIewModel(R.drawable.card_item_kingscrown,"deepak","02-Feb-2001"))
        data.add(itemsVIewModel(R.drawable.card_item_teamwork,"mayur","12-Now-2020"))
        data.add(itemsVIewModel(R.drawable.card_item_kingscrown,"JD","02-Dec-2001"))
        data.add(itemsVIewModel(R.drawable.card_item_teamwork,"Abhishek","22-Aug-2020"))
        data.add(itemsVIewModel(R.drawable.card_item_kingscrown,"Sachin","07-April-2001"))
        data.add(itemsVIewModel(R.drawable.card_item_teamwork,"Audibling","25-Aug-2020"))
        data.add(itemsVIewModel(R.drawable.card_item_kingscrown,"Human Tree","19-April-2001"))
        data.add(itemsVIewModel(R.drawable.card_item_teamwork,"Audibling","20-Aug-2020"))
        data.add(itemsVIewModel(R.drawable.card_item_kingscrown,"Human Tree","30-April-2001"))
        data.add(itemsVIewModel(R.drawable.card_item_teamwork,"Audibling","31-Aug-2020"))
        data.add(itemsVIewModel(R.drawable.card_item_kingscrown,"Human Tree","29-April-2001"))













        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter_RcV_promo(this,data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }
}