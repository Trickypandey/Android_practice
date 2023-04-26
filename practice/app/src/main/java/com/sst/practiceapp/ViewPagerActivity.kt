package com.sst.practiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sst.Adapters.PageAdapter
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityViewPagerBinding
import com.sst.practiseapp.databinding.ActivityWorkingHourBinding

class ViewPagerActivity : AppCompatActivity() {
    lateinit var binding:ActivityViewPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_view_pager)
        binding.viewPager.arrowScroll(1)
        binding.viewPager.adapter=PageAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }
}