package com.example.practiceui

import android.content.Intent
import android.os.Bundle
import android.widget.TableLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class activit_lifeCycle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activit_life_cycle)
        val toast = Toast.makeText(this, "onCreate Called", Toast.LENGTH_LONG).show()
        var intent:Intent = Intent(this,Activity_temp2::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        val toast = Toast.makeText(this, "onStart Called", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        val toast = Toast.makeText(this, "onRestart Called", Toast.LENGTH_LONG).show()


    }

    override fun onPause() {
        super.onPause()
        val toast = Toast.makeText(this, "onPause Called", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        val toast = Toast.makeText(this, "onResume Called", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        val toast = Toast.makeText(this, "onStop Called", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        val toast = Toast.makeText(this, "onDestroy Called", Toast.LENGTH_LONG).show()
    }
}