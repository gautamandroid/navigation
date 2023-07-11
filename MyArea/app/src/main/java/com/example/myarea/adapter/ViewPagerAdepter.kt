package com.example.myarea.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.myarea.databinding.ActivityviewPagerAdapterBinding
import com.example.myarea.modal.ViewPager

class ViewPagerAdepter(var context: Context, var page: ArrayList<ViewPager>) : PagerAdapter() {

    private lateinit var binding: ActivityviewPagerAdapterBinding
    override fun getCount(): Int {
        return page.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var item = page[position]
        binding =
            ActivityviewPagerAdapterBinding.inflate(LayoutInflater.from(context), container, false)
        binding.ivImageview.setImageResource(item.image)

        container.addView(binding.root)
        return binding.root

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }


}