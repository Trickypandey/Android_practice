package com.example.entheos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val signInTextView :TextView=findViewById(R.id.textView)
        signInTextView.setOnClickListener(){
            val temp=Intent(this,login_Activity::class.java)
            startActivity(temp)
        }
    }
}