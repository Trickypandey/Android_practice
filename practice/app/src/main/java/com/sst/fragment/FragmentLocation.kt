package com.sst.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sst.practiceapp.PracticeBtn
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.FragmentLocationBinding


class FragmentLocation : Fragment() {
    lateinit var binding: FragmentLocationBinding
    var btnlist:ArrayList<PracticeBtn> = ArrayList()
  override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
      binding = DataBindingUtil.inflate(inflater, R.layout.fragment_location, container, false)
      val supportMapFragment:SupportMapFragment=childFragmentManager.findFragmentById(R.id.googlemap) as SupportMapFragment

      supportMapFragment.getMapAsync{
          it.clear()
      }
        return binding.root
    }
    fun onMapReady(googleMap: GoogleMap) {
        val mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions()
            .position(sydney)
            .title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}