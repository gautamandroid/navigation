package com.example.myarea.activity.homeActivity.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myarea.databinding.ActivityNavigationAdepterBinding
import com.example.myarea.modal.NavigationAdepterData


class NavigationAdepter(var context: Context, var onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<NavigationAdepter.MyViewHolder>() {

    class MyViewHolder(navigation: ActivityNavigationAdepterBinding) :
        RecyclerView.ViewHolder(navigation.root) {
        var bind = navigation

        }


    var list: MutableList<NavigationAdepterData>? = null

    interface OnItemClickListener {
        fun onItemClick(navigationAdepterData: NavigationAdepterData, position: Int)

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NavigationAdepter.MyViewHolder {
        var navi =
            ActivityNavigationAdepterBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(navi)
    }


    override fun onBindViewHolder(holder: NavigationAdepter.MyViewHolder, position: Int) {
        var navi = list?.get(position)
        if (navi != null) {
            holder.bind.userprofile.setImageResource(navi.img)
        }
        if (!navi?.subtitle.isNullOrEmpty()) {
            holder.bind.tvSubtitle.text = navi?.subtitle
            holder.bind.tvSubtitle.isVisible = true
        } else {
            holder.bind.tvSubtitle.isVisible = false
        }
        holder.bind.title.text = navi?.title
        holder.itemView.setOnClickListener {
            if (navi != null) {
                onItemClickListener.onItemClick(navi, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    fun setList(items: ArrayList<NavigationAdepterData>) {
        this.list = items
        notifyDataSetChanged()
    }


}