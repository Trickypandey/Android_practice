package com.my.test

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity2 : AppCompatActivity(),My12 {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var num=IntArray(10)
        var temp:String
        var nam=arrayOfNulls<String>(10)


        val recyclerview = findViewById<RecyclerView>(R.id.rv)


        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<ItemViewModel>()

        for(i in 0..9)
        {
            num[i]=(Math.random() * ((100 + 1) - 0) + 0).toInt()
            temp=randomID()
            nam[i]=temp
        }

        for (i in 0..9) {
            nam[i]?.let { ItemViewModel(num[i], it) }?.let { data.add(it) }
        }

        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter



    }
    private fun randomID(): String = List(16) {
        (('a'..'z') + ('A'..'Z') + ('0'..'9')).random()
    }.joinToString("")

    override fun getposition(p: Int,con:Context) {
        when(p)
        {
            0->Toast.makeText(con,"aaaa",Toast.LENGTH_SHORT).show()
            else->Toast.makeText(con,"else",Toast.LENGTH_SHORT).show()
        }



       // TODO("Not yet implemented")
    }


}
interface My12{
    fun getposition(p:Int,con: Context)
}