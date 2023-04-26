package com.sst.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sst.practiceapp.AdapterRvAdditemHome
import com.sst.practiceapp.BottlomNavigationActivity
import com.sst.practiceapp.ModelClassAddItem
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.FragmentHomeBinding


class FragmentHome(var activityp: BottlomNavigationActivity) : Fragment() {

    lateinit var binding: FragmentHomeBinding

    lateinit var list: ArrayList<ModelClassAddItem>
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        recyclerView= binding.rvList
        recyclerView.layoutManager= GridLayoutManager(activity,2)
        list= ArrayList()

        binding.additem.setOnClickListener {
            list.add(ModelClassAddItem(binding.listItem.text.toString()))
            addItemtoList(list)

        }

        return binding.root
    }
    fun addItemtoList(list: ArrayList<ModelClassAddItem>){

        recyclerView.adapter= AdapterRvAdditemHome(list,activityp)
    }

}