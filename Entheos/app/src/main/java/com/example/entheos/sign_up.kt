package com.example.entheos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.cardview.widget.CardView

class sign_up : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.temp_signup)

//        if (supportActionBar != null) {
//            supportActionBar!!.hide()
//        }
//        var createAce: TextView =findViewById(R.id.textView_login_now)
//        createAce.setOnClickListener(){
//            var loginAccInt : Intent = Intent(this,login_Activity::class.java)
//            startActivity(loginAccInt)
//        }
//        var aboutUs:CardView=findViewById(R.id.buttoncreate_acc)
//        aboutUs.setOnClickListener{
//            var aboutUsIntent =Intent(this,about_us::class.java)
//            startActivity(aboutUsIntent)
//        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }
}