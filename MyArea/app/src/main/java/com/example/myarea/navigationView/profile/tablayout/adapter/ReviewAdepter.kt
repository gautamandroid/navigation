package com.example.myarea.navigationView.profile.tablayout.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myarea.R
import com.example.myarea.databinding.IteamreviewLayoutBinding
import com.example.myarea.modal.PostAdepterData

class ReviewAdepter(var context: Context, var onClick: OnItemClick) :
    RecyclerView.Adapter<ReviewAdepter.MyViewHolder>() {

    var postt: ArrayList<PostAdepterData>? = null
    var like: Boolean = true
    var dislinke: Boolean = true
    var isreadmoreClick: Boolean = false

    class MyViewHolder(post: IteamreviewLayoutBinding) : RecyclerView.ViewHolder(post.root) {
        var bind = post
    }

    interface OnItemClick {

        fun OnItemClick(data: PostAdepterData, position: Int)
        fun OnDeletClick(data: PostAdepterData, position: Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var pos = IteamreviewLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(pos)
    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var po = postt!![position]
        holder.bind.imProfile.setImageResource(po.image)
        holder.bind.tvName.text = po.name
        holder.bind.titles.text = po.title
        holder.bind.RtRattingbar.rating = po.rating.toFloat()
        holder.bind.tvDescription.text = po.description
        holder.bind.imgMain.setImageResource(po.restoimage)
        holder.bind.imMoreimage.setImageResource(po.moreimage)
        holder.bind.tvRatinggg.text =
            context.getString(com.example.myarea.R.string._4_5, po.rating.toInt())


        if (po.description.length > 200) {
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

        holder.bind.threeDots.setOnClickListener {

            popUpMenu(holder, position, po)

        }
        //holder.bind.ivLike.setImageResource(R.drawable.ic_like)
        //  holder.bind.ivLike.setImageResource(R.drawable.ic_likeb)
        //   holder.bind.ivLike.setImageResource(R.drawable.ic_deselike)
        //   holder.bind.ivLike.setImageResource(R.drawable.ic_dislikered)
    }

    override fun getItemCount(): Int {
        return postt!!.size
    }

    fun setList(historiyL: ArrayList<PostAdepterData>) {
        this.postt = historiyL
        notifyDataSetChanged()

    }


    private fun popUpMenu(holder: MyViewHolder, position: Int, po: PostAdepterData) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


        val view = inflater.inflate(R.layout.dailog_editdelet, null, false)
        val pw = PopupWindow(
            view,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )

        pw.isOutsideTouchable = true
        pw.isFocusable = true


        val a = IntArray(2)
        holder.bind.threeDots.getLocationInWindow(a)
        pw.showAtLocation(
            holder.bind.threeDots, Gravity.NO_GRAVITY,
            a[0] - 300,
            a[1] + holder.bind.threeDots.height
        )
        //pw.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.popup_background))

        val edit = pw.contentView.findViewById<TextView>(R.id.tv_edit)
        edit.setOnClickListener {
            onClick.OnItemClick(data = po, position)
            pw.dismiss()
        }
        val delete = pw.contentView.findViewById<TextView>(R.id.tv_delete)
        delete.setOnClickListener {

            onClick.OnDeletClick(data = po, position)
            //deleteListener.OnItemDelete
//            notifyItemRemoved(position)
            pw.dismiss()
        }

    }

}