package com.example.myarea.fragment.vidioFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myarea.R
import com.example.myarea.databinding.FragmentVidioBinding
import com.example.myarea.fragment.vidioFragment.adapter.AdeptrVidio
import com.example.myarea.modal.VidioModal


class VidioFragment : Fragment() {

    lateinit var binding: FragmentVidioBinding
    lateinit var videoAdepter: AdeptrVidio

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentVidioBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        videoAdepter = AdeptrVidio(requireContext())
        binding.viewpager.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.viewpager.adapter = videoAdepter

        videoAdepter.setList(getdat())

    }

    fun getdat(): ArrayList<VidioModal> {
        var post = ArrayList<VidioModal>()

        post.add(
            VidioModal(
                R.drawable.img_home,
                "Gautam Vaholiay",
                "Android devloper",
                "5",
                video = R.raw.demo_video
            )
        )
        post.add(
            VidioModal(
                R.drawable.img_home,
                " Vaholiay",
                "Android devloper",
                "2",
                video = R.raw.demo_video
            )
        )
        post.add(
            VidioModal(
                R.drawable.img_home,
                "yash hingu",
                "Android devloper",
                "4",
                video = R.raw.demo_video
            )
        )
        post.add(
            VidioModal(
                R.drawable.img_home,
                "Virat kohli ",
                "Android devloper",
                "3",
                video = R.raw.demo_video
            )
        )

        return post
    }

}