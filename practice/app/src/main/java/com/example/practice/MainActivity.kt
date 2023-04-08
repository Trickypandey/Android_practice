package com.example.practice

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import java.net.Inet4Address


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var data_list= hashMapOf<String,String>()
    lateinit var bSignUp: Button
    lateinit var rgGender : RadioGroup
    lateinit var rbgenderval:RadioButton
    var tvGender : TextView?=null
    lateinit var tvSpinner : TextView
    lateinit var sSpinner :Spinner
    lateinit var eNumber :TextView
    lateinit var eAddress: TextView
    var  eHobby :LinearLayout?=null
    // four text fields
    lateinit var etName: EditText
    lateinit var etpassword: EditText
    lateinit var etEmail: EditText
    lateinit var etConfPassword: EditText
    lateinit var cb1Hobby:CheckBox
    lateinit var cb2Hobby:CheckBox
    lateinit var cb3Hobby:CheckBox
    var tvHobby:TextView?=null
    lateinit var textViewShowPassword:TextView
    var isAllFieldsChecked = false
    // regex for email format
    val emailPattern = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\$"
//    regex for name
    val namePattern ="/^[a-zA-Z ]*\$/"

    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       display()
        val  title:TextView =findViewById(R.id.textview_for_login)
        title.setOnClickListener{
            val imgintent=Intent(this,image_acrivity::class.java)
            startActivity(imgintent)
        }
        bSignUp=findViewById(R.id.sign_up)
        bSignUp.setOnClickListener(){
            if(signUp()){
                var intentsecond_activity = Intent(this,second_activity::class.java)
                intentsecond_activity.putExtra("data",data_list)
                startActivity(intentsecond_activity)
            }

        }
    }
    //submit the sign up form
    fun signUp():Boolean{
        createInstance()
        if (checkAllFields()) return true
        return false
    }
    // creating instance of the variable
    fun createInstance(){
        textViewShowPassword=findViewById(R.id.text_showpass)
        eAddress=findViewById(R.id.address)
        eNumber = findViewById(R.id.phone_number)
        etEmail=findViewById(R.id.address)
        tvHobby=findViewById(R.id.hobby_text)
        cb1Hobby=findViewById(R.id.checkBox)
        cb2Hobby=findViewById(R.id.checkBox2)
        cb3Hobby=findViewById(R.id.checkBox3)
        rgGender=findViewById(R.id.gender_value)
        tvSpinner=findViewById(R.id.spinner_text)
        sSpinner=findViewById(R.id.spinner_list)
        eHobby = findViewById(R.id.hobby_value)
        tvGender=findViewById(R.id.gender_text)
        etName=findViewById(R.id.username)
        etpassword=findViewById(R.id.password)
        etConfPassword=findViewById(R.id.confirmpas)
        etEmail=findViewById(R.id.email)
        rbgenderval=findViewById(rgGender.checkedRadioButtonId)
        textViewShowPassword.setOnClickListener(View.OnClickListener {
            if (textViewShowPassword.getText().equals("Show")) {
                etpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                etConfPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                textViewShowPassword.setText("Hide")
                etpassword.setSelection(etpassword.text.length)
                etConfPassword.setSelection(etConfPassword.text.length)
            } else {
                textViewShowPassword.setText("Show")
                etpassword.setTransformationMethod(PasswordTransformationMethod())
                etConfPassword.setTransformationMethod(PasswordTransformationMethod())
                etpassword.setSelection(etpassword.text.length)
                etConfPassword.setSelection(etConfPassword.text.length)
            }
        })
    }

    // check that all imput are present or not
    private fun checkAllFields():Boolean{
        if (etName.length()==0){
            etName.error="This field is required"
            etName.requestFocus()
            return false
        }
        if (eNumber.length()==0){
            eNumber.error="This field is required"
            return false
        }
        if (eAddress.length()==0){
            eAddress.error="This field is required"
            return false
        }
        if (etEmail.length()==0 ){
            etEmail.error = "This field is required"
            return false
        }
        if (!validateEmail(etEmail)) return true
        if (etpassword.length()==0){
            etpassword.error = "This field is required"
            return false
        }
        if(etConfPassword.length()==0){
            etConfPassword.error = "This field is required"
            return false
        }
        if (etpassword.text.toString()!=etConfPassword.text.toString()){
            etConfPassword.error="Password must be same"
            return false
        }
        if (sSpinner.selectedItemPosition == 0){
            Toast.makeText(this,"Selected a Country",Toast.LENGTH_SHORT).show()
            return false
        }
        else{
            tvSpinner.error=null
        }
        if (!cb1Hobby.isChecked && !cb2Hobby.isChecked && !cb3Hobby.isChecked ){
            Toast.makeText(this,"Select a Hobby",Toast.LENGTH_SHORT).show()
            return false

        }
        else{
            if (cb1Hobby.isChecked)  data_list.put("hobby1",cb1Hobby.text.toString())
            if (cb2Hobby.isChecked)  data_list.put("hobby2",cb2Hobby.text.toString())
            if (cb3Hobby.isChecked)  data_list.put("hobby3",cb3Hobby.text.toString())
            tvHobby!!.error=null
        }
        addTOList()
        return true
    }
    // add data to lis tto send it to second activity
    fun addTOList(){
        var temp:RadioButton = findViewById(rgGender.checkedRadioButtonId)
        data_list.put("name",etName.text.toString())
        data_list.put("Email",etEmail.text.toString())
        data_list.put("Country",sSpinner.selectedItem.toString())
        data_list.put("gender",temp.text.toString())
        data_list.put("number",eNumber.text.toString())
        data_list.put("address",eAddress.text.toString())
    }
    // validate email
    fun validateEmail(view: EditText):Boolean {
        if (view.text.matches(emailPattern.toRegex())) {
            view.error=null
            return true
        } else {
            view.error="Enter a valid email"
            return false
        }
    }

    // validate name
    fun validateName(view: EditText):Boolean{
        if (view.text.matches(namePattern.toRegex())){
            view.error=null
            return true
        }
        else{
            view.error="Enter a valid name"
            return false
        }
    }
    //     to show the item of spinner
    fun display(){
        val spinner: Spinner = findViewById(R.id.spinner_list)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.birds,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }

    //
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    //
     override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}