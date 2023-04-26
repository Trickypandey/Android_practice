package com.sst.practiceapp

import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityWorkingHourBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class WorkingHourActivity : AppCompatActivity() {
    val dateFormat = SimpleDateFormat("HH:mm")
    lateinit var inTime :String
    lateinit var outTime :String
    private lateinit var binding : ActivityWorkingHourBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_working_hour)
        binding.actionBarBack.setOnClickListener {
            finish()
        }
        var curremtTime = Date()
        var temp = dateFormat.format(curremtTime)
        binding.currentTime.text=convert(temp)
        clickAll()
    }
    fun clickAll(){
        binding.changeCurTime.setOnClickListener {
            timePicker(binding.currentTime)
        }
        binding.selectChecoutTime.setOnClickListener {
            timePicker(binding.checkoutTime)
        }
        binding.calculate.setOnClickListener {
            if (binding.checkoutTime.text != "") {
                inTime = timeCoversion12to24(binding.currentTime.text.toString())
                outTime = timeCoversion12to24(binding.checkoutTime.text.toString())
                Log.e("Tag for temp time in 24" ,"$inTime $outTime")
                val date1 = SimpleDateFormat("HH:mm").parse(outTime)
                val date2 = SimpleDateFormat("HH:mm").parse(inTime)
                val time_difference = date1.time - date2.time
                if (time_difference > 0) {
                    binding.checkout24.text=outTime
                    binding.checkin24.text=inTime
                    binding.displayTime.text =
                        "Your Working Time is ${time_difference / (1000 * 60 * 60)} hours ${(time_difference / (1000 * 60)) - (time_difference / (1000 * 60 * 60)) * 60} Minutes"
                } else {
                    Toast.makeText(this, "Checkin should be less than Checkout", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            else{
                Toast.makeText(this,"Select a CheckOut Time",Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun timePicker(vieW: TextView){
        val c: Calendar = Calendar.getInstance()
        val hour: Int = c.get(Calendar.HOUR_OF_DAY)
        val minute: Int = c.get(Calendar.MINUTE)
//        val timezone :
        val timePickerDialog = TimePickerDialog(this,
            { view, hourOfDay, minute ->
                // in our text view.
                 vieW.text=convert("$hourOfDay:$minute")
            }, hour, minute,false
        )
        timePickerDialog.show()
    }
    fun convert(str: String):String{
        var temp =""

        var list = mutableListOf<Int>()
        str.split(":").forEach {
            list.add(it.toInt())
        }
        if (list[0].toInt() in 0..12){
            temp="${list[0]}:${list[1]} AM"
        }
        else{
           temp = "${list[0]-12}:${list[1]} PM"
        }

        return temp
    }

    @Throws(ParseException::class)
    fun timeCoversion12to24(twelveHoursTime: String): String {

        //Date/time pattern of input date (12 Hours format - hh used for 12 hours)
        val df: SimpleDateFormat = SimpleDateFormat("hh:mm aa")

        //Date/time pattern of desired output date (24 Hours format HH - Used for 24 hours)
        val outputformat: SimpleDateFormat = SimpleDateFormat("HH:mm ss")
        var date: Date? = null
        var output: String? = null

        //Returns Date object
        date = df.parse(twelveHoursTime)

        //old date format to new date format
        output = outputformat.format(date)
        println(output)
        return output
    }
}