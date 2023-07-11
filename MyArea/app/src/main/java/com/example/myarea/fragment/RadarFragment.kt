package com.example.myarea.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myarea.R
import com.example.myarea.databinding.FragmentRadarBinding


class RadarFragment : Fragment() {

lateinit var binding:FragmentRadarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      binding= FragmentRadarBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


}