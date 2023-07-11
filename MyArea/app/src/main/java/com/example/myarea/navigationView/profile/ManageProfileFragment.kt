package com.example.myarea.navigationView.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myarea.R
import com.example.myarea.databinding.FragmentManageProfileBinding


class ManageProfileFragment : Fragment() {

    lateinit var binding: FragmentManageProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentManageProfileBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btChangepassword.setOnClickListener {
            findNavController().navigate(R.id.action_manageProfileFragment_to_changePasswordFragment)
        }


    }
}