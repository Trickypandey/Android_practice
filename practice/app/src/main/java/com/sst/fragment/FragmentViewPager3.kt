package com.sst.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.FragmentViewPager2Binding
import com.sst.practiseapp.databinding.FragmentViewPager3Binding

class FragmentViewPager3 : Fragment() {
    lateinit var binding: FragmentViewPager3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_view_pager3, container, false)
        Handler().postDelayed({
            binding.text.visibility=View.VISIBLE
        },1500)
        return binding.root
    }

}