package com.example.entheos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class homepage : AppCompatActivity() {
    private lateinit var bottomNavigationMenuView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        bottomNavigationMenuView = findViewById(R.id.bottom_navigation)
        bottomNavigationMenuView.setOnClickListener { item ->
            when (item.id) {
                R.id.homepage -> {
                    true
                }
                R.id.homepage -> {
                    true
                }
                R.id.homepage -> {
                    true
                }
                R.id.homepage -> {
                    true
                }
                R.id.homepage -> {
                    true
                }
                R.id.homepage -> {
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}