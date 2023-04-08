package com.example.practiceui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity_temp2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp2)
        var btn=findViewById<Button>(R.id.click_me)
        btn.setOnClickListener {
            val first = blankFragment1()
            var tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.fragment_section,first)
            tran.addToBackStack(null)
            tran.commit()
        }
        var btn2=findViewById<Button>(R.id.button2)
        btn2.setOnClickListener {
            val second = blankFragment2()
            var tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.fragment_section,second)
            tran.addToBackStack(null)
            tran.commit()
        }
    }
}