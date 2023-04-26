package com.sst.practiceapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sst.constants.Constants
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivitySignUpBottomNavBinding


class SignUpBottomNavActivity : AppCompatActivity() {
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    lateinit var binding: ActivitySignUpBottomNavBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_sign_up_bottom_nav)
        display()
        showPass()
        binding.signUp.setOnClickListener(){
            if(signUp()){
                val intentsecond_activity = Intent(this, BottlomNavigationActivity::class.java)
                startActivity(intentsecond_activity)
            }
            addtoSharedpre()
        }

    }
    fun showPass(){
        binding.textShowpass.setOnClickListener(View.OnClickListener {
            if (binding.textShowpass.text.equals("Show")) {
                binding.password.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.confirmpas.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.textShowpass.text = "Hide"
            } else {
                binding.textShowpass.text = "Show"
                binding.password.transformationMethod = PasswordTransformationMethod()
                binding.confirmpas.transformationMethod = PasswordTransformationMethod()
                binding.password.setSelection(binding.password.text.length)
                binding.confirmpas.setSelection(binding.confirmpas.text.length)
            }
        })
    }

    fun signUp():Boolean{
        if (checkAllFields()) {


            return true
        }
        return false
    }
    // check that all imput are present or not
    private fun checkAllFields():Boolean{

        if (binding.username.text.isEmpty()){
            binding.username.error="This field is required"
            binding.username.requestFocus()
            return false
        }

        if (binding.phoneNumber.text.isEmpty()){
            binding.phoneNumber.error="This field is required"
            binding.phoneNumber.requestFocus()
            return false
        }
        else{
            binding.phoneNumber.error=null
        }
        if (binding.address.text.isEmpty()){
            binding.address.error="This field is required"
            binding.address.requestFocus()
            return false
        }else{
            binding.address.error= null
        }
        if (binding.email.text.isEmpty()){
            binding.email.error = "This field is required"
            binding.email.requestFocus()
            return false
        }
        else{
            binding.email.error= null
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(binding.email.text).matches()){
            binding.email.error="Enter a valid email"
            binding.email.requestFocus()
            return false
        }
        else{
            binding.email.error= null
        }
        if (binding.password.text.isEmpty()){
            binding.password.error = "This field is required"
            binding.password.requestFocus()
            return false
        }
        if(binding.confirmpas.text.isEmpty()){
            binding.confirmpas.error = "This field is required"
            binding.confirmpas.requestFocus()
            return false
        }
        if (binding.password.text.toString()!=binding.confirmpas.text.toString()){
            binding.confirmpas.error="Password must be same"
            binding.confirmpas.requestFocus()
            return false
        }
        if (binding.spinnerList.selectedItemPosition==0){
            Toast.makeText(this,"Selected a Country", Toast.LENGTH_SHORT).show()
            return false
        }
        else{
            binding.spinnerText.error=null
        }
        if (!binding.checkBox.isChecked && !binding.checkBox2.isChecked && !binding.checkBox3.isChecked ){
            Toast.makeText(this,"Select a Hobby", Toast.LENGTH_SHORT).show()
            return false
        }
        else{

            binding.hobbyText.error=null
        }

        return true
    }
    // add data to lis tto send it to second activity

    // validate email
    fun validateEmail(view: EditText):Boolean {
        return view.text.matches(emailPattern.toRegex())
    }

    //     to show the item of spinner
    fun display(){
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.birds,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.spinnerList.adapter = adapter
        }
    }
    fun addtoSharedpre(){
        val sharedPreferences = getSharedPreferences(Constants.shred_pre_user_data, MODE_PRIVATE)
        var myEdit: SharedPreferences.Editor = sharedPreferences.edit()
        myEdit.clear()
        myEdit.apply()
        var temp: RadioButton = findViewById(binding.genderValue.checkedRadioButtonId)
        myEdit.putString("name",binding.username.text.toString())
        myEdit.putString("email",binding.email.text.toString())
        myEdit.putString("country",binding.spinnerList.selectedItem.toString())
        myEdit.putString("gender",temp.text.toString())
        myEdit.putString("number",binding.phoneNumber.text.toString())
        myEdit.putString("address",binding.address.text.toString())
        if (!binding.checkBox.isChecked){
            myEdit.remove("hobby1")
        }else{
            myEdit.putString("hobby1", binding.checkBox.text.toString())
        }
        if (!binding.checkBox2.isChecked){
            myEdit.remove("hobby2")
        }else{
            myEdit.putString("hobby2", binding.checkBox2.text.toString())
        }
        if (!binding.checkBox3.isChecked){
            myEdit.remove("hobby3")
        }
        else{
            myEdit.putString("hobby3",binding.checkBox3.text.toString())
        }
        myEdit.putBoolean("login",true)
//        myEdit.putString("hobby1", cb2Hobby.text.toString())
//        myEdit.putString("hobby2", cb2Hobby.text.toString())
//        myEdit.putString("hobby3",cb3Hobby.text.toString())
        myEdit.apply()
    }
}