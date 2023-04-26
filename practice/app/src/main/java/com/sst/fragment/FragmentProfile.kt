package com.sst.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sst.constants.Constants
import com.sst.practiceapp.SignUpBottomNavActivity
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.FragmentProfileBinding

class FragmentProfile : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        // Inflate the layout for this fragment

        val sh = activity!!.getSharedPreferences(Constants.shred_pre_user_data, AppCompatActivity.MODE_PRIVATE)
        if (!sh.getBoolean("login",false)){
            val intentsecond_activity = Intent(activity, SignUpBottomNavActivity::class.java)
            startActivity(intentsecond_activity)

        }
        displayData(true)
//        val edit = view.findViewById<Button>(R.id.edit)
//        edit.setOnClickListener {
//
//            val intent = Intent(activity,ProfileActivity::class.java)
//            activity?.startActivity(intent)
////            var frameLayout = FragmentProfilePage()
////            var fragmentManager= activity?.supportFragmentManager?.beginTransaction()
////            fragmentManager?.replace(R.id.fragment_section,frameLayout)
////            fragmentManager?.disallowAddToBackStack()
////            fragmentManager?.commit()
//        }
        return binding.root
    }
    fun displayData(temp:Boolean){
        val sh = activity?.getSharedPreferences("Profiledata", AppCompatActivity.MODE_PRIVATE)
        if (sh != null) {
            binding.name.text= binding.name.text.toString()+" "+sh.getString("name","")
        }
        if (sh != null) {
            binding.email.text= binding.email.text.toString() + " " + sh.getString("email", "")
        }
        if (sh != null) {
            binding.gender.text= binding.gender.text.toString() + " " + sh.getString("gender", "")
        }
        if (sh != null) {
            binding.country.text= binding.country.text.toString() + " " + sh.getString("country", "")
        }
        if (sh != null) {
            if (sh.getString("hobby1","")!=""){
                binding.hobby.text= binding.hobby.text.toString() + " " + sh.getString("hobby1", "")
            }
        }
        if (sh != null) {
            if (sh.getString("hobby2","")!=""){
                binding.hobby.text="${binding.hobby.text} ${sh.getString("hobby2","")}"
            }
        }
        if (sh != null) {
            if (sh.getString("hobby3","")!=""){
                binding.hobby.text="${binding.hobby.text} ${sh.getString("hobby3","")}"
            }
        }
        if (sh != null) {
            binding.address.text="${binding.address.text} ${sh.getString("address","")}"
        }
        if (sh != null) {
            binding.phoneNumber.text="${binding.phoneNumber.text } ${sh.getString("number","")}"
        }
    }
}