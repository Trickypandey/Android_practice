package com.sst.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sst.practiceapp.HomeActivity
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.FragmentProfileBinding
import com.sst.practiseapp.databinding.FragmentViewPager1Binding
import kotlin.concurrent.thread

// TODO: Rename parameter arguments, choose names that match

class FragmentViewPager1 : Fragment() {

    lateinit var binding: FragmentViewPager1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_pager1, container, false)

        Log.e("onStart","called")
        Handler().postDelayed({
            binding.text.visibility=View.VISIBLE
        },1500)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResums","called")
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onStop() {
        super.onStop()
        Log.e("onStop","called")
    }

    override fun onPause() {
        super.onPause()
        Log.e("onPause","called")

    }
    override fun onDestroyView(){
        super.onDestroyView()
        Log.e("onDestroyView","called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("onDetach","called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("onCreate","called")
    }

}