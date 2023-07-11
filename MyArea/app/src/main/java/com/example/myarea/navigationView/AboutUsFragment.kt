package com.example.myarea.navigationView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myarea.R
import com.example.myarea.activity.homeActivity.HomeActivity


class AboutUsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as HomeActivity).binding.codinatorBottombar.isVisible = false
        (activity as HomeActivity).binding.imgPlus.isVisible = false
        (activity as HomeActivity).binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as HomeActivity).binding.codinatorBottombar.isVisible = true
        (activity as HomeActivity).binding.imgPlus.isVisible = true
        (activity as HomeActivity).binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }
}