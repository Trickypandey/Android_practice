package com.example.entheos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView

class login_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        var createAce:TextView=findViewById(R.id.textView_create_acc)
        createAce.setOnClickListener(){
            var createAccInt :Intent=Intent(this,sign_up::class.java)
            startActivity(createAccInt)
        }
        var homepagebtn:TextView=findViewById(R.id.textView)
        homepagebtn.setOnClickListener{
            var createAccInt :Intent= Intent(this,homepage::class.java)
            startActivity(createAccInt)
        }
    }
}