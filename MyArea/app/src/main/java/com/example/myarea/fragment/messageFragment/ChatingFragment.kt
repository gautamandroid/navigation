package com.example.myarea.fragment.messageFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myarea.R
import com.example.myarea.databinding.FragmentChatBinding
import com.example.myarea.databinding.FragmentChatingBinding


class ChatingFragment : Fragment() {

    lateinit var binding: FragmentChatingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChatingBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}