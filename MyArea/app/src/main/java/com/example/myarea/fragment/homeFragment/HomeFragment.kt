package com.example.myarea.fragment.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myarea.R
import com.example.myarea.databinding.FragmentHomeBinding
import com.example.myarea.fragment.homeFragment.adapter.HomeAdepter
import com.example.myarea.modal.HomeLocationData

class HomeFragment : Fragment(), HomeAdepter.OnItemClick {

    lateinit var binding: FragmentHomeBinding
    lateinit var homeAdepter: HomeAdepter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeAdepter = HomeAdepter(requireContext(), this)
        binding.reHomee.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.reHomee.adapter = homeAdepter

        homeAdepter.setList(getdat())

        binding.imgFilter.setOnClickListener {


        }

    }

    fun getdat(): ArrayList<HomeLocationData> {
        var post = ArrayList<HomeLocationData>()

        post.add(
            HomeLocationData(
                R.drawable.imgg_post,
                "Wade Warren",
                "Veranda Restaurant",
                "4",
                "I am very with the service, I think this is a best restaurant....I am very with the service, I think this is a best restaurant....fyftydxrtyertdttdtdrtdftcfggfserfgrtI am very with the service, I think this is a best restaurant....I am very with the service-",
                R.drawable.img_resturent,
                R.drawable.img_allphotos
            )
        )
        post.add(
            HomeLocationData(
                R.drawable.imgg_post,
                "Wade Warren",
                "Veranda Restaurant",
                "4",
                "4517 Washington Ave. Manchester, Kentucky 39495",
                R.drawable.img_resturent,
                R.drawable.img_allphotos
            )
        )
        post.add(
            HomeLocationData(
                R.drawable.imgg_post,
                "Wade Warren",
                "Veranda Restaurant",
                "4",
                "4517 Washington Ave. Manchester, Kentucky 39495",
                R.drawable.img_resturent,
                R.drawable.img_allphotos
            )
        )
        return post
    }

    override fun OnItemClick(data: HomeLocationData, position: Int) {


    }
}