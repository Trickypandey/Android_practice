package com.my.test

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.time.Instant

class CustomAdapter (private val mList: List<ItemViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    lateinit var con:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        con=parent.context
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.number.text= ItemsViewModel.number.toString()
        holder.name.text=ItemsViewModel.name.toString()

    holder.itemView.setOnClickListener {

     val obj=MainActivity2()
        obj.getposition(position,con)
        /*when (position)
        {   0 -> Toast.makeText(con,ItemsViewModel.number.toString()+"\n"+ItemsViewModel.name.toString(),Toast.LENGTH_SHORT).show()
            1 ->i1()
            2 -> Toast.makeText(con,ItemsViewModel.number.toString()+"\n"+ItemsViewModel.name.toString(),Toast.LENGTH_SHORT).show()
            3-> Toast.makeText(con,ItemsViewModel.number.toString()+"\n"+ItemsViewModel.name.toString(),Toast.LENGTH_SHORT).show()
            4 -> Toast.makeText(con,ItemsViewModel.number.toString()+"\n"+ItemsViewModel.name.toString(),Toast.LENGTH_SHORT).show()
            5 -> Toast.makeText(con,ItemsViewModel.number.toString()+"\n"+ItemsViewModel.name.toString(),Toast.LENGTH_SHORT).show()
            6 -> Toast.makeText(con,ItemsViewModel.number.toString()+"\n"+ItemsViewModel.name.toString(),Toast.LENGTH_SHORT).show()
            7 -> Toast.makeText(con,ItemsViewModel.number.toString()+"\n"+ItemsViewModel.name.toString(),Toast.LENGTH_SHORT).show()
            8 -> Toast.makeText(con,ItemsViewModel.number.toString()+"\n"+ItemsViewModel.name.toString(),Toast.LENGTH_SHORT).show()
            9 -> Toast.makeText(con,ItemsViewModel.number.toString()+"\n"+ItemsViewModel.name.toString(),Toast.LENGTH_SHORT).show()
        }*/
    }

        //holder.adapterPosition.set
    }
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val number: TextView = itemView.findViewById(R.id.number)
        val name: TextView = itemView.findViewById(R.id.name)


    }
    fun i1(){
        val intent = Intent(con,MainActivity::class.java);
        con.startActivity(intent);
    }
}