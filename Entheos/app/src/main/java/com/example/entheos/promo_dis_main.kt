package com.example.entheos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class promo_dis_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promo_dis_main)
        val nDate = intent.getStringExtra("date")
        val textView : TextView=findViewById(R.id.textView4)
        textView.setText(nDate)
        val imageView:ImageView = findViewById(R.id.logo_main)
        val nImage =intent.getIntExtra("image",0)
        imageView.setImageResource(nImage)
    }
}