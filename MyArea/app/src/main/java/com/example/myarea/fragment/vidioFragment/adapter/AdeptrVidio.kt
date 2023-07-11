package com.example.myarea.fragment.vidioFragment.adapter


import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.myarea.databinding.VidioLayoutBinding
import com.example.myarea.modal.VidioModal


class AdeptrVidio(var context: Context) : RecyclerView.Adapter<AdeptrVidio.MyViewHolder>() {

    class MyViewHolder(vidio: VidioLayoutBinding) : RecyclerView.ViewHolder(vidio.root) {
        var bind = vidio
    }

    var vido: ArrayList<VidioModal>? = null
    var like: Boolean = true
    var dislinke: Boolean = true


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var vidg = VidioLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(vidg)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var vd = vido!![position]
        holder.bind.RtRattingbar.rating = vd.rating.toFloat()
        holder.bind.txtRating.text = vd.rating
        holder.bind.titles.text = vd.name
        holder.bind.imgProfiles.setImageResource(vd.image)
        holder.bind.tvName.text = vd.descrp
        val uri: Uri =
            Uri.parse("android.resource://" + context.packageName + "/" + com.example.myarea.R.raw.demo_video)
        holder.bind.vdPley.setVideoURI(uri)
        holder.bind.vdPley.setOnPreparedListener {

            it.start()
            it.videoHeight

        }

        holder.bind.imLike.setOnClickListener {

            if (like == true) {
                holder.bind.imLike.setImageResource(com.example.myarea.R.drawable.ic_likeb)
                like = false
                notifyDataSetChanged()

            } else {
                like = true
                holder.bind.imLike.setImageResource(com.example.myarea.R.drawable.ic__home_likeblue)
                notifyDataSetChanged()
            }

        }



        holder.bind.imDisslike.setOnClickListener {

            if (dislinke == true) {
                holder.bind.imDisslike.setImageResource(com.example.myarea.R.drawable.ic_home_disslike)
                dislinke = false
                notifyDataSetChanged()
            } else {
                dislinke = true
                holder.bind.imDisslike.setImageResource(com.example.myarea.R.drawable.ic_deselike)
                notifyDataSetChanged()
            }

        }

    }

    override fun getItemCount(): Int {
        return vido!!.size
    }

    fun setList(historiy: ArrayList<VidioModal>) {
        this.vido = historiy
        notifyDataSetChanged()

    }

}