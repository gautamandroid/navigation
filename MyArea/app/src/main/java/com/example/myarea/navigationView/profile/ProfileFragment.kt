package com.example.myarea.navigationView.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.fragment.findNavController
import com.example.myarea.R
import com.example.myarea.activity.homeActivity.HomeActivity
import com.example.myarea.databinding.FragmentProfileBinding
import com.example.myarea.navigationView.profile.tablayout.PostFragment
import com.example.myarea.navigationView.profile.tablayout.ReviewFragment
import com.google.android.material.tabs.TabLayout


class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    var tabLayout: TabLayout? = null

    var reviewFragment: ReviewFragment? = null
    var postFragment: PostFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btEditprofile.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_manageProfileFragment)

        }

        (activity as HomeActivity).binding.codinatorBottombar.isVisible = false
        (activity as HomeActivity).binding.imgPlus.isVisible = false
        (activity as HomeActivity).binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        reviewFragment = ReviewFragment()
        postFragment = PostFragment()


//        tabLayout=findViewById(R.id.tab_layout);
//        viewPager=findViewById(R.id.view_pager);

//        binding.tbTablayout.setupWithViewPager(binding.viViewpagerProfile)
//
//        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)
//
//        viewPagerAdapter.addFragment(postFragment!!, "POST")
//        viewPagerAdapter.addFragment(reviewFragment!!, "REVIEW")
//        viewPager?.setAdapter(viewPagerAdapter)
//
//        binding.tbTablayout.getTabAt(0)?.setText("Post")
//        binding.tbTablayout.getTabAt(1)?.setText("Review")


        setUpViewPager()
        binding.tbTablayout.setupWithViewPager(binding.viViewpagerProfile)
        binding.tbTablayout.getTabAt(0)?.setText("Post")
        binding.tbTablayout.getTabAt(1)?.setText("Review")

        binding.tbTablayout.setupWithViewPager(binding.viViewpagerProfile)
        binding.tbTablayout.getTabAt(0)?.setIcon(R.drawable.ic_postt_selected)
        binding.tbTablayout.getTabAt(1)?.setIcon(R.drawable.ic_review)


        binding.tbTablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(requireContext(), R.color.black))
        //binding.tbTablayout.setSelectedIc(ContextCompat.getColor(requireContext(), R.color.black))
    }

    private fun setUpViewPager() {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(PostFragment(), "Post")
        adapter.addFragment(ReviewFragment(), "Review")
        binding.viViewpagerProfile?.adapter = adapter

    }

    private class ViewPagerAdapter(fm: FragmentManager) :
        FragmentPagerAdapter(fm) {
        private val fragments: ArrayList<Fragment> = ArrayList()
        private val fragmentTitles: ArrayList<String> = ArrayList()

        //add fragment to the viewpager
        fun addFragment(fragment: Fragment, title: String) {
            fragments.add(fragment)
            fragmentTitles.add(title)
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        //to setup title of the tab layout
        @Nullable
        override fun getPageTitle(position: Int): CharSequence? {
            return fragmentTitles[position]
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        (activity as HomeActivity).binding.codinatorBottombar.isVisible = true
        (activity as HomeActivity).binding.imgPlus.isVisible = true
        (activity as HomeActivity).binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }
}