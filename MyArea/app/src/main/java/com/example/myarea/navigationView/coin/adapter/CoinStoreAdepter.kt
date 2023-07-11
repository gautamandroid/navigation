package com.example.myarea.navigationView.coin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myarea.R
import com.example.myarea.databinding.ActivityCoinadapterBinding
import com.example.myarea.modal.CoinAdepter

class CoinStoreAdepter(var context: Context, var tcoin: MutableList<CoinAdepter>) :
    RecyclerView.Adapter<CoinStoreAdepter.MyViewHolder>() {

    class MyViewHolder(coin: ActivityCoinadapterBinding) : RecyclerView.ViewHolder(coin.root) {
        var bind = coin
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var co = ActivityCoinadapterBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(co)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var coinss = tcoin[position]
        holder.bind.tvTotal.text = coinss.total
        holder.bind.tvPriceCoin.text = context.getString(R.string.historiy_coin, coinss.price)
        holder.bind.imCoin.setImageResource(coinss.image)


    }

    override fun getItemCount(): Int {
        return tcoin.size
    }

}