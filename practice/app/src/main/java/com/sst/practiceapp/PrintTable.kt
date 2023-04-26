package com.sst.practiceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityPrintTableBinding

class PrintTable : AppCompatActivity() {
    private lateinit var binding: ActivityPrintTableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_print_table)
        var number = intent.getIntExtra("Number",0)
        binding.title.text="Table of $number"
        var temp:String=""
        for (i in 1..10){
            temp +="$number X $i = ${number*i}\n"
        }
        binding.textView.text=temp
    }
}