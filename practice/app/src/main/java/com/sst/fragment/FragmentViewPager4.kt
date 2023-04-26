package com.sst.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.FragmentViewPager4Binding


class FragmentViewPager4 : Fragment() {

    lateinit var binding:FragmentViewPager4Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_view_pager4, container, false)
        // Inflate the layout for this fragment
        Handler().postDelayed({
            binding.text.visibility=View.VISIBLE
        },1500)
        return binding.root
    }

}