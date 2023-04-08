package com.example.aboutme

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
//        findViewById<Button>(R.id.done_button).setOnClickListener(){
//            addNickname(it)
//        }
        binding.doneButton.setOnClickListener(){
            addNickname(it)
        }
    }
    fun addNickname(view :View){
        binding.nicknameText.text=binding.nicknameEdit.text
        binding.nicknameEdit.visibility=View.GONE
        binding.doneButton.visibility=View.GONE
        binding.nicknameText.visibility= View.VISIBLE
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        var nicknameText = findViewById<TextView>(R.id.nickname_text)
//        nicknameText.text=editText.text
//        editText.visibility=View.GONE
//        view.visibility=View.GONE
//        nicknameText.visibility=View.VISIBLE
    }
}