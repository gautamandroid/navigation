package com.example.myarea.navigationView.coin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myarea.R
import com.example.myarea.activity.homeActivity.HomeActivity
import com.example.myarea.databinding.FragmentCoinBinding
import com.example.myarea.modal.CoinAdepter
import com.example.myarea.navigationView.coin.adapter.CoinStoreAdepter

class CoinFragment : Fragment() {

    lateinit var binding: FragmentCoinBinding
    lateinit var coinAdapter: CoinStoreAdepter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCoinBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coinAdapter = CoinStoreAdepter(requireContext(), getListOfData(requireContext()))
        binding.rcCoin.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.rcCoin.adapter = coinAdapter


        binding.btPurchase.setOnClickListener {
            findNavController().navigate(R.id.action_coinFragment_to_coinHistoryFragment)
        }

    }

    fun getListOfData(context: Context): ArrayList<CoinAdepter> {
        var items = ArrayList<CoinAdepter>()

        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        items.add(CoinAdepter("20", R.drawable.ic_coin, "25"))
        return items
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as HomeActivity).binding.codinatorBottombar.visibility = View.GONE
        (activity as HomeActivity).binding.imgPlus.visibility = View.GONE
        (activity as HomeActivity).binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as HomeActivity).binding.codinatorBottombar.isVisible = true
        (activity as HomeActivity).binding.imgPlus.isVisible = true
        (activity as HomeActivity).binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }
}