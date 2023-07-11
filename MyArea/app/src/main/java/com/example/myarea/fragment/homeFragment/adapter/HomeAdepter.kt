package com.example.myarea.fragment.homeFragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myarea.databinding.ItemHomerecyclerBinding
import com.example.myarea.modal.HomeLocationData

class HomeAdepter(var context: Context, var click: OnItemClick) :
    RecyclerView.Adapter<HomeAdepter.MyViewHolder>() {


    class MyViewHolder(homePost: ItemHomerecyclerBinding) : RecyclerView.ViewHolder(homePost.root) {
        var bind = homePost
    }

    var location: ArrayList<HomeLocationData>? = null
    var like: Boolean = true
    var dislinke: Boolean = true
    var isreadmoreClick: Boolean = false

    interface OnItemClick {

        fun OnItemClick(data: HomeLocationData, position: Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var post = ItemHomerecyclerBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(post)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var home = location!![position]
        holder.bind.imProfile.setImageResource(home.image)
        holder.bind.tvName.text = home.name
        holder.bind.titles.text = home.title
        holder.bind.RtRattingbar.rating = home.rating.toFloat()
        holder.bind.tvDescription.text = home.description
        holder.bind.imgMain.setImageResource(home.restoimage)
        holder.bind.imMoreimage.setImageResource(home.moreimage)
        holder.bind.tvRatinggg.text =
            context.getString(com.example.myarea.R.string._4_5, home.rating.toInt())

        if (home.description.length > 200) {
            holder.bind.tvReadmore.isVisible = true
            holder.bind.tvDescription.maxLines = 2
        } else {
            holder.bind.tvReadmore.isVisible = false
        }

        holder.bind.tvReadmore.setOnClickListener {
            if (isreadmoreClick == false) {
                holder.bind.tvReadmore.setText("....See_Less")
                holder.bind.tvDescription.maxLines = Int.MAX_VALUE
                isreadmoreClick = true

            } else {
                isreadmoreClick = false
                holder.bind.tvDescription.maxLines = 2
                holder.bind.tvReadmore.setText("....Seee_More")
            }

        }

        holder.bind.ivLike.setOnClickListener {

            if (like == true) {
                holder.bind.ivLike.setImageResource(com.example.myarea.R.drawable.ic_like)
                like = false
                notifyDataSetChanged()

            } else {
                like = true
                holder.bind.ivLike.setImageResource(com.example.myarea.R.drawable.ic_likeb)
                notifyDataSetChanged()
            }

        }

        holder.bind.tvDisslike.setOnClickListener {

            if (dislinke == true) {
                holder.bind.tvDisslike.setImageResource(com.example.myarea.R.drawable.ic_dislikered)
                dislinke = false
                notifyDataSetChanged()
            } else {
                dislinke = true
                holder.bind.tvDisslike.setImageResource(com.example.myarea.R.drawable.ic_deselike)
                notifyDataSetChanged()
            }

        }
        holder.bind.locationReturent.setOnClickListener {
            click.OnItemClick(data = home, position)
        }

    }

    override fun getItemCount(): Int {
        return location!!.size
    }

    fun setList(historiy: ArrayList<HomeLocationData>) {
        this.location = historiy
        notifyDataSetChanged()

    }

}