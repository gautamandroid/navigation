package com.example.myarea.navigationView.coin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myarea.R
import com.example.myarea.databinding.FragmentCoinHistoryBinding
import com.example.myarea.modal.CoinHistoriyData
import com.example.myarea.navigationView.coin.adapter.CoinHistoriyAdepter


class CoinHistoryFragment : Fragment() {

    lateinit var binding: FragmentCoinHistoryBinding
    lateinit var adapterHistoriy: CoinHistoriyAdepter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCoinHistoryBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapterHistoriy = CoinHistoriyAdepter(requireContext())
        binding.rcCoinhistoriy.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rcCoinhistoriy.adapter = adapterHistoriy

        adapterHistoriy.setList(getdata())
    }


    fun getdata(): ArrayList<CoinHistoriyData> {
        var historiy = ArrayList<CoinHistoriyData>()

        historiy.add(
            CoinHistoriyData(
                R.drawable.mg_historiy,
                "David Rajaaa",
                "23 March, 2023",
                "1 hours ago",
                "120",
                true
            )
        )
        historiy.add(
            CoinHistoriyData(
                R.drawable.img_shistoriy,
                "David Warner",
                "23 March, 2023",
                "1 hours ago",
                "120",
                false
            )
        )
        historiy.add(
            CoinHistoriyData(
                R.drawable.img_shistoriy,
                "Jalaram Locho",
                "23 March, 2023",
                "1 hours ago",
                "120",
                false
            )
        )
        historiy.add(
            CoinHistoriyData(
                R.drawable.mg_historiy,
                "Parking of Payble",
                "23 March, 2023",
                "1 hours ago",
                "120",
                true
            )
        )
        historiy.add(
            CoinHistoriyData(
                R.drawable.img_shistoriy,
                "One Man Armiy",
                "23 March, 2023",
                "1 hours ago",
                "120",
                true
            )
        )
        historiy.add(
            CoinHistoriyData(
                R.drawable.img_shistoriy,
                "go to Village",
                "23 March, 2023",
                "1 hours ago",
                "120",
                true
            )
        )
        historiy.add(
            CoinHistoriyData(
                R.drawable.mg_historiy,
                "Yash Hingu of Btech",
                "23 March, 2023",
                "1 hours ago",
                "120",
                false
            )
        )
        historiy.add(
            CoinHistoriyData(
                R.drawable.mg_historiy,
                "Yash Hingu of Btech",
                "23 March, 2023",
                "1 hours ago",
                "120",
                false
            )
        )
        historiy.add(
            CoinHistoriyData(
                R.drawable.mg_historiy,
                "Yash Hingu of Btech",
                "23 March, 2023",
                "1 hours ago",
                "120",
                false
            )
        )
        historiy.add(
            CoinHistoriyData(
                R.drawable.mg_historiy,
                "Yash Hingu of Btech",
                "23 March, 2023",
                "1 hours ago",
                "120",
                false
            )
        )
        historiy.add(
            CoinHistoriyData(
                R.drawable.mg_historiy,
                "Yash Hingu of Btech",
                "23 March, 2023",
                "1 hours ago",
                "120",
                false
            )
        )
        historiy.add(
            CoinHistoriyData(
                R.drawable.mg_historiy,
                "Yash Hingu of Btech",
                "23 March, 2023",
                "1 hours ago",
                "120",
                false
            )
        )

        return historiy
    }

}