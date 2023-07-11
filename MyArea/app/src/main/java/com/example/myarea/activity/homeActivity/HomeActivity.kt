package com.example.myarea.activity.homeActivity

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myarea.R
import com.example.myarea.activity.homeActivity.adapter.NavigationAdepter
import com.example.myarea.databinding.ActivityHomeBinding
import com.example.myarea.modal.NavigationAdepterData


class HomeActivity : AppCompatActivity(), NavigationAdepter.OnItemClickListener {

    lateinit var binding: ActivityHomeBinding
    var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    lateinit var naviAdepter: NavigationAdepter
    var navController: NavController? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        naviAdepter = NavigationAdepter(this, this)
        binding.navigation.rcyNavigation.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.navigation.rcyNavigation.adapter = naviAdepter
        naviAdepter.setList(getListOfData())

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fram_layout) as NavHostFragment
        navController = navHostFragment.navController
        AppBarConfiguration(
            setOf(
                
                R.id.homeFragment, R.id.vidioFragment, R.id.radarFragment, R.id.chatFragment

            )
        )
        binding.bottomNavigation.setupWithNavController(navController!!)
        binding.bottomNavigation.background = null

//        binding.fab.getLayoutParams().height
//        val params = binding.framLayout.getLayoutParams()
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, binding.drawer, R.string.navopen, R.string.navclose)
        binding.drawer.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle!!.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navDrawer.setNavigationItemSelectedListener { items ->

            val id = items.itemId
            if (id == R.id.drawer) {

            }
            //  Toast.makeText(this, "it", Toast.LENGTH_SHORT).show()

            NavigationUI.onNavDestinationSelected(items, navController!!)
            binding.drawer.closeDrawer(GravityCompat.START)
            true
        }
    }


    fun getListOfData(): ArrayList<NavigationAdepterData> {
        val items = ArrayList<NavigationAdepterData>()
        items.add(
            NavigationAdepterData(
                1,
                R.drawable.ic_manage_profile,
                "Manage Profile",
                "Change your account information",
                navigationId = R.id.profileFragment
            )
        )
        items.add(
            NavigationAdepterData(
                2,
                R.drawable.ic_coin,
                "Coin Store",
                navigationId = R.id.coinFragment
            )
        )
        items.add(
            NavigationAdepterData(
                3,
                R.drawable.ic_tearmcondition,
                "Terms & Condition",
                navigationId = R.id.termAndConditionFragment
            )
        )
        items.add(
            NavigationAdepterData(
                4,
                R.drawable.ic_about_us,
                "About Us",
                navigationId = R.id.aboutUsFragment
            )
        )
        items.add(NavigationAdepterData(5, R.drawable.ic_logout, "Log Out"))

        return items
    }

    override fun onItemClick(navigationAdepterData: NavigationAdepterData, position: Int) {
        if (navigationAdepterData.navigationId != null) {
            binding.drawer.closeDrawer(GravityCompat.START)
            navController?.navigate(navigationAdepterData.navigationId!!)

        } else {
            binding.drawer.closeDrawer(GravityCompat.START)
            val dialog = Dialog(this, R.style.DialogTheme)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(true)
            dialog.setContentView(R.layout.activity_logout)

            val cancel = dialog.findViewById(R.id.iv_close) as ImageView
            val close = dialog.findViewById(R.id.tv_cancle) as TextView
            val yes = dialog.findViewById(R.id.tv_yes) as TextView



            cancel.setOnClickListener {
                dialog.dismiss()
            }
            close.setOnClickListener {
                dialog.dismiss()
            }
            yes.setOnClickListener {
                Toast.makeText(this, "logout successful", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }


            dialog.show()


        }
    }
}