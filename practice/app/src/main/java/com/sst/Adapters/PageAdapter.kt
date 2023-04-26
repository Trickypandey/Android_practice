package com.sst.Adapters

import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sst.fragment.FragmentViewPager1
import com.sst.fragment.FragmentViewPager2
import com.sst.fragment.FragmentViewPager3
import com.sst.fragment.FragmentViewPager4

class PageAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 4 ;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {

                return FragmentViewPager1()
            }
            1 -> {
                return FragmentViewPager2()
            }
            2 -> {
                return FragmentViewPager3()
            }
            3 -> {
                return FragmentViewPager4()
            }
            else->{
                return FragmentViewPager1()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Tab 1"
            }
            1 -> {
                return "Tab 2"
            }
            2 -> {
                return "Tab 3"
            }
            3 -> {
                return "Tab 4"
            }
        }
        return super.getPageTitle(position)
    }

}
