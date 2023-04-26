package com.sst.practiceapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sst.practiseapp.R

class second_activity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sh = getSharedPreferences("UserData", MODE_PRIVATE)
        setContentView(R.layout.activity_second)
        val name=findViewById<TextView>(R.id.name)
        val email=findViewById<TextView>(R.id.email)
        val gender=findViewById<TextView>(R.id.gender)
        val country=findViewById<TextView>(R.id.country)
        val hobby=findViewById<TextView>(R.id.hobby)
        val address=findViewById<TextView>(R.id.address)
        val number = findViewById<TextView>(R.id.phone_number)
        val intent = intent;
        val hashMap = intent.getSerializableExtra("data") as HashMap<*, *>?
        val back =findViewById<ImageButton>(R.id.action_bar_back)
        back.setOnClickListener{
            finish()
        }
        if (hashMap != null) {
            name.text = "${name.text} ${sh.getString("name","")}"
            email.text="${email.text} ${sh.getString("email","")}"
            gender.text="${gender.text} ${sh.getString("gender","")}"
            country.text="${country.text} ${sh.getString("country","")}"
            if (sh.getString("hobby1","")!=""){
                hobby.text="${hobby.text} ${sh.getString("hobby1","")}"
            }
            if (sh.getString("hobby2","")!=""){
                hobby.text="${hobby.text} ${sh.getString("hobby2","")}"
            }
            if (sh.getString("hobby3","")!=""){
                hobby.text="${hobby.text} ${sh.getString("hobby3","")}"
            }
            address.text="${address.text} ${sh.getString("address","")}"
            number.text="${number.text } ${sh.getString("number","")}"
        }
    }
}