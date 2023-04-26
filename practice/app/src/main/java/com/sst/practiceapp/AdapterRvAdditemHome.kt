package com.sst.practiceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sst.practiseapp.R
import java.util.ArrayList

class AdapterRvAdditemHome(private val list: ArrayList<ModelClassAddItem>, private val activity: BottlomNavigationActivity):
    RecyclerView.Adapter <AdapterRvAdditemHome.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_homeitem,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text=list[position].item
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val text: TextView =itemView.findViewById(R.id.itemtext)


    }
}