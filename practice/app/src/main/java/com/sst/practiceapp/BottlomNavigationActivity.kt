package com.sst.practiceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sst.fragment.*
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityBottlomNavigationBinding

class BottlomNavigationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottlomNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_bottlom_navigation)
        if (binding.bottomNavigation.selectedItemId == R.id.homepage){
            val frameLayout = FragmentHome(this)
            val fragmentManager=supportFragmentManager.beginTransaction()
            fragmentManager.replace(R.id.fragment_section,frameLayout)
            fragmentManager.disallowAddToBackStack()
            fragmentManager.commit()
        }

        menuClick()
    }
    fun menuClick(){
//        Log.e("Menu","${binding.bottomNavigation.menu.findItem(binding.bottomNavigation.selectedItemId).javaClass}")
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homepage -> {
                    val frameLayout = FragmentHome(this)
                    val fragmentManager=supportFragmentManager.beginTransaction()
                    fragmentManager.replace(R.id.fragment_section,frameLayout)
                    fragmentManager.disallowAddToBackStack()
                    fragmentManager.commit()
                    true
                }
                R.id.location -> {
                    var frameLayout = FragmentLocation()
                    var fragmentManager=supportFragmentManager.beginTransaction()
                    fragmentManager.replace(R.id.fragment_section,frameLayout)
                    fragmentManager.disallowAddToBackStack()
                    fragmentManager.commit()
                    true
                }
                R.id.chats -> {
                    var frameLayout = FragmentChats()
                    var fragmentManager=supportFragmentManager.beginTransaction()
                    fragmentManager.replace(R.id.fragment_section,frameLayout)
                    fragmentManager.disallowAddToBackStack()
                    fragmentManager.commit()
                    true
                }
                R.id.events -> {
                    var frameLayout = FragmentEvents()
                    var fragmentManager=supportFragmentManager.beginTransaction()
                    fragmentManager.replace(R.id.fragment_section,frameLayout)
                    fragmentManager.disallowAddToBackStack()
                    fragmentManager.commit()
                    true
                }
                R.id.profile -> {
                    var frameLayout = FragmentProfile()
                    var fragmentManager=supportFragmentManager.beginTransaction()
                    fragmentManager.replace(R.id.fragment_section,frameLayout)
                    fragmentManager.disallowAddToBackStack()
                    fragmentManager.commit()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}