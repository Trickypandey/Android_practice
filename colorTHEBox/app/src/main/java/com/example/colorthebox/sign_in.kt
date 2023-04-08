package com.example.colorthebox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class sign_in : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }
}