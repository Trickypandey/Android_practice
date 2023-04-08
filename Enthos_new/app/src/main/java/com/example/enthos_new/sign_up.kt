package com.example.entheos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class sign_up : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        var createAce: TextView =findViewById(R.id.textView_login_now)
        createAce.setOnClickListener(){
            var loginAccInt : Intent = Intent(this,login_Activity::class.java)
            startActivity(loginAccInt)
        }

    }
}