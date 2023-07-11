package com.example.myarea.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myarea.R
import com.example.myarea.adapter.ViewPagerAdepter
import com.example.myarea.databinding.ActivityViewPagerBinding
import com.example.myarea.modal.ViewPager

class ViewPagerActivity : AppCompatActivity() {

    private var imagList = arrayListOf<ViewPager>()
    lateinit var binding: ActivityViewPagerBinding
    lateinit var adapter: ViewPagerAdepter
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            var ie =Intent(this,LoginActivity::class.java)
             startActivity(ie)

        }


        prepareData()
        adapter = ViewPagerAdepter(this, imagList)
        binding.viewpager.adapter = adapter
        binding.dotsIndicator.attachTo(binding.viewpager)



        binding.next.setOnClickListener {


            binding.viewpager.isSelected = binding.loginlayout.isSelected != true


            if (currentIndex < adapter.count) {
                currentIndex++
                binding.viewpager.currentItem = currentIndex
            } else {
                Toast.makeText(this, "finish", Toast.LENGTH_SHORT).show()
            }

        }
        binding.viewpager.addOnPageChangeListener(object :
            androidx.viewpager.widget.ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

                currentIndex = position

                if (currentIndex == adapter.count - 1) {

                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

    }

    private fun prepareData() {
        imagList.add(ViewPager(R.drawable.f_image_viewoager))
        imagList.add(ViewPager(R.drawable.s_virepager))
        imagList.add(ViewPager(R.drawable.t_viewpager))

    }

}