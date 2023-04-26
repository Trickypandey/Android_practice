package com.sst.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.FragmentViewPager1Binding
import com.sst.practiseapp.databinding.FragmentViewPager2Binding


class FragmentViewPager2 : Fragment() {
    lateinit var binding: FragmentViewPager2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_view_pager2, container, false)
        Handler().postDelayed({
            binding.text.visibility=View.VISIBLE
        },1500)
        return binding.root
    }

}