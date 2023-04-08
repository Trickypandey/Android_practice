package com.example.colorthebox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.time.Instant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)
        val button: Button = findViewById(R.id.button2)
        val signInTextView :TextView=findViewById(R.id.textView6)
        button.setOnClickListener{
            val intent = Intent(this, sign_in::class.java)
            startActivity(intent)
        }
        signInTextView.setOnClickListener {
            openSignUp(it)
        }
    }
    fun openSignUp(view: View){
        val intent = Intent(this,sign_in::class.java)
        startActivity(intent)
    }
}