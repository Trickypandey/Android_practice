package com.sst.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.FragmentProfilePageBinding

class FragmentProfilePage : Fragment() {
    private lateinit var binding: FragmentProfilePageBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentProfilePageBinding.bind(view)


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val back = activity?.findViewById<ImageButton>(R.id.action_bar_back)
        if (back != null) {
            back.setOnClickListener{
                activity?.finish()
            }
        }
        return inflater.inflate(R.layout.fragment_profile_page, container, false)
    }


}