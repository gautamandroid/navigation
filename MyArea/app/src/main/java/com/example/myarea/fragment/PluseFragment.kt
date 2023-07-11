package com.example.myarea.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myarea.R
import com.example.myarea.databinding.FragmentPluseBinding


class PluseFragment : Fragment() {

    lateinit var binding: FragmentPluseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPluseBinding.inflate(layoutInflater, container, false)
        return binding.root

    }


}