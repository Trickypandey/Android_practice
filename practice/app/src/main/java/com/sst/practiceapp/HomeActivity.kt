package com.sst.practiceapp

import android.content.DialogInterface
import android.content.Intent
import android.database.DatabaseUtils
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val editText= EditText(this)
        editText.inputType = InputType.TYPE_CLASS_NUMBER
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.signUp.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.imageSelector.setOnClickListener{
            val imgintent=Intent(this, image_acrivity::class.java)
            startActivity(imgintent)
        }
        binding.tablePrint.setOnClickListener {
            val pictureDialog = AlertDialog.Builder(this)
            pictureDialog.setTitle("Select Action")
            pictureDialog.setMessage("Enter a number")
            pictureDialog.setView(editText)
            pictureDialog.setPositiveButton("Submit",
                DialogInterface.OnClickListener { dialog, which ->
                val intent =Intent(this,PrintTable::class.java)
                intent.putExtra("Number",Integer.parseInt(editText.text.toString()))
//                    binding.tablePrint.setText(println(editText.text::class.java.typeName).toString())
                startActivity(intent)
            })
            pictureDialog.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
            pictureDialog.show()

        }


    }
}