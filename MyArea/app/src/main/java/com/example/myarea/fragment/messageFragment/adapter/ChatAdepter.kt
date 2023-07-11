package com.example.myarea.fragment.messageFragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myarea.R
import com.example.myarea.databinding.ActivityChatAdepterBinding
import com.example.myarea.modal.DataChatAdepter

class ChatAdepter(var context: Context, var list: MutableList<DataChatAdepter>) :
    RecyclerView.Adapter<ChatAdepter.MyViewHolder>() {

    class MyViewHolder(chatitem: ActivityChatAdepterBinding) :
        RecyclerView.ViewHolder(chatitem.root) {
        var bind = chatitem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var chat = ActivityChatAdepterBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(chat)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var list = list[position]
        holder.bind.tvTitle.text = list.title
        holder.bind.tvSubtitle.text = list.subtitle
        holder.bind.tvMsgtime.text = context.getString(R.string.data_min, list.time);
        holder.bind.tvPpandingmsg.text = list.message.toString()
        holder.bind.imgUser.setImageResource(list.img)


    }

    override fun getItemCount(): Int {
        return list.size
    }

}