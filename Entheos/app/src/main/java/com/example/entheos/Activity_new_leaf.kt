package com.example.entheos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Activity_new_leaf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_leaf)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }
}