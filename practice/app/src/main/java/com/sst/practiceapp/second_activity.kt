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

        setContentView(R.layout.activity_second)
        val name=findViewById<TextView>(R.id.name)
        val email=findViewById<TextView>(R.id.email)
        val gender=findViewById<TextView>(R.id.gender)
        val country=findViewById<TextView>(R.id.country)
        val hobby=findViewById<TextView>(R.id.hobby)
        val address=findViewById<TextView>(R.id.address)
        val number = findViewById<TextView>(R.id.phone_number)

        val intent = getIntent();
        val hashMap = intent.getSerializableExtra("data") as HashMap<*, *>?
        val back =findViewById<ImageButton>(R.id.action_bar_back)
        back.setOnClickListener{
            finish()
        }
        if (hashMap != null) {
            name.text = "${name.text} ${hashMap["name"]}"
            email.text="${email.text} ${hashMap["Email"]}"
            gender.text="${gender.text} ${hashMap["gender"]}"
            country.text="${country.text} ${hashMap["Country"]}"
            if (hashMap["hobby1"]!=null){
                hobby.text="${hobby.text} ${hashMap["hobby1"]}"
            }
            if (hashMap["hobby2"]!=null){
                hobby.text="${hobby.text} ${hashMap["hobby2"]}"
            }
            if (hashMap["hobby3"]!=null){
                hobby.text="${hobby.text} ${hashMap["hobby3"]}"
            }
            address.text="${address.text} ${hashMap["address"]}"
            number.text="${number.text } ${hashMap["number"]}"
        }
    }
}