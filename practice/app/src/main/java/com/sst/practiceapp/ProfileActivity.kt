package com.sst.practiceapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_profile)
        Log.e("Recvhed ","zsbfjkabsdf")
        displayData(true)
    }
    fun displayData(temp:Boolean){
        val sh = getSharedPreferences("UserData", MODE_PRIVATE)
        Log.e("login","${sh.getBoolean("login",false)}")
        binding.name.text= sh.getString("name","")
        binding.email.text="${binding.email.text} ${sh.getString("email","")}"
        binding.gender.text="${binding.gender.text} ${sh.getString("gender","")}"
        binding.country.text="${binding.country.text} ${sh.getString("country","")}"
        if (sh.getString("hobby1","")!=""){
            binding.hobby.text="${binding.hobby.text} ${sh.getString("hobby1","")}"
        }
        if (sh.getString("hobby2","")!=""){
            binding.hobby.text="${binding.hobby.text} ${sh.getString("hobby2","")}"
        }
        if (sh.getString("hobby3","")!=""){
            binding.hobby.text="${binding.hobby.text} ${sh.getString("hobby3","")}"
        }
        binding.address.text="${binding.address.text} ${sh.getString("address","")}"
        binding.phoneNumber.text="${binding.phoneNumber.text } ${sh.getString("number","")}"
    }
}