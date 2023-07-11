package com.example.myarea.navigationView.coin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myarea.R
import com.example.myarea.databinding.ActivityCoinhistoriyadapterBinding
import com.example.myarea.modal.CoinHistoriyData

class CoinHistoriyAdepter(var context: Context) :
    RecyclerView.Adapter<CoinHistoriyAdepter.MyViewHolder>() {

    var coin: ArrayList<CoinHistoriyData>? = null

    class MyViewHolder(historiy: ActivityCoinhistoriyadapterBinding) :
        RecyclerView.ViewHolder(historiy.root) {
        var bind = historiy
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var his =
            ActivityCoinhistoriyadapterBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(his)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var coins = coin!![position]
        holder.bind.igProfile.setImageResource(coins.ing)
        holder.bind.tvDate.text = coins.data
        holder.bind.tvMinAgo.text = coins.time
        holder.bind.tvTotalcoin.text = context.getString(R.string.historiy_coin, coins.total)
        holder.bind.tvProfilename.text = coins.name

        if (coins.isCredited == true) {
            holder.bind.tvTotalcoin.setTextColor(ContextCompat.getColor(context, R.color.green))
        } else {
            holder.bind.tvTotalcoin.setTextColor(ContextCompat.getColor(context, R.color.dotorcolor))
        }

        if (position%2==0){
            holder.bind.rcMainlayout.setBackgroundColor(ContextCompat.getColor(context, R.color.red_dark))
        }
    }


    fun setList(historiyL: ArrayList<CoinHistoriyData>) {
        this.coin = historiyL
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return coin!!.size
    }

}