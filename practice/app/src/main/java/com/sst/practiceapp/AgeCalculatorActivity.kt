package com.sst.practiceapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityAgeCalculatorBinding
import java.text.SimpleDateFormat
import java.util.*


class AgeCalculatorActivity : AppCompatActivity() {
    val dateFormat = SimpleDateFormat("dd/M/yyyy")
    var curdate: String = ""
    var bdate: String = ""
    private lateinit var binding: ActivityAgeCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_age_calculator)
        binding.currentDate.text = dateFormat.format(currentDate())
        onallClick()
    }
    private fun  onallClick(){
        binding.actionBarBack.setOnClickListener {
            finish()
        }
        binding.changeCurDate.setOnClickListener {
            showCalender(binding.currentDate)
        }

        binding.selectDate.setOnClickListener {
            showCalender(binding.birthday)
            if (binding.birthday.text.isEmpty()){
                binding.selectDate.text="Change Date"
            }
        }


        binding.calculate.setOnClickListener {
            bdate = binding.birthday.text.toString()
            curdate = binding.currentDate.text.toString()
            if (binding.birthday.text!=""){
                val date1 = SimpleDateFormat("dd/M/yyyy").parse(curdate)
                val date2 = SimpleDateFormat("dd/M/yyyy").parse(bdate)
                val time_difference = date1.time - date2.time
                if (time_difference>0){
                    binding.age.text="${(time_difference / (1000L *60*60*24*365))} Years and ${ (time_difference / (1000*60*60*24)) % 365} Days"
                    val animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fade_in);
                    binding.age.startAnimation(animZoomIn)
                }
                else{
                    Toast.makeText(this,"Birthday should be less than current day",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this,"Select a BirthDay",Toast.LENGTH_SHORT).show()
            }
        }

    }
//    private fun check(cur :Date, birth :Date):Boolean{
//        if (cur.year>=birth.year) {
//            Log.e("TAG","${cur.date } and ${birth.date}")
//            return true
//        }
//        return false
//    }
    fun currentDate(): Date {
        val temp = Date()
        return temp
    }

    private fun showCalender(vieW: TextView) {
        val c = Calendar.getInstance()
        val mYear = c[Calendar.YEAR]
        val mMonth = c[Calendar.MONTH]
        val mDay = c[Calendar.DAY_OF_MONTH]
        val datePickerDialog = DatePickerDialog(
            this,
            { view, year, monthOfYear, dayOfMonth ->
                vieW.text = dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year
            },
            mYear,
            mMonth,
            mDay
        )
        datePickerDialog.datePicker.maxDate=c.timeInMillis
        datePickerDialog.show()
    }
}