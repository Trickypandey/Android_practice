package com.example.entheos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.concurrent.fixedRateTimer

class homepage : AppCompatActivity() {
    private lateinit var bottomNavigationMenuView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

//        on clicklistener for promo and discount
        val prom_dis:CardView=findViewById(R.id.promo_discount)
        prom_dis.setOnClickListener{
            val promo_dis_Intent=Intent(this,promotion_activity::class.java)
            startActivity(promo_dis_Intent)
        }

        // getting the the instant of the frame layout to set the fragment


        bottomNavigationMenuView = findViewById(R.id.bottom_navigation)

        bottomNavigationMenuView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homepage -> {
                    Toast.makeText(this,"homepage",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.location -> {
                    Toast.makeText(this,"location",Toast.LENGTH_SHORT).show()
                    var frameLayout = BlankFragment()
                    var fragmentManager=supportFragmentManager.beginTransaction()
                    fragmentManager.replace(R.id.main_container,frameLayout)
                    fragmentManager.addToBackStack(null)
                    fragmentManager.commit()
                    true
                }
                R.id.chats -> {
                    Toast.makeText(this,"chats",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.events -> {
                    Toast.makeText(this,"event",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profile -> {
                     Toast.makeText(this,"location",Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    Toast.makeText(this,"location",Toast.LENGTH_SHORT).show()
                    false
                }
            }
        }
    }
}