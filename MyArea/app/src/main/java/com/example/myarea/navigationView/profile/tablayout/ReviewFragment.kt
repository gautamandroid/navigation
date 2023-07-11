package com.example.myarea.navigationView.profile.tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myarea.R
import com.example.myarea.databinding.FragmentReviewBinding
import com.example.myarea.modal.PostAdepterData
import com.example.myarea.navigationView.profile.tablayout.adapter.ReviewAdepter


class ReviewFragment : Fragment(), ReviewAdepter.OnItemClick {

    lateinit var binding: FragmentReviewBinding
    lateinit var reviewAdepter: ReviewAdepter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentReviewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reviewAdepter = ReviewAdepter(requireContext(), this)
        binding.rcReview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rcReview.adapter = reviewAdepter
        reviewAdepter.setList(getdat())

    }

    fun getdat(): ArrayList<PostAdepterData> {
        var post = ArrayList<PostAdepterData>()

        post.add(
            PostAdepterData(
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
            PostAdepterData(
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
            PostAdepterData(
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

    override fun OnItemClick(data: PostAdepterData, position: Int) {
        Toast.makeText(requireContext(), "editable", Toast.LENGTH_SHORT).show()
    }

    override fun OnDeletClick(data: PostAdepterData, position: Int) {
        Toast.makeText(requireContext(), "your data delete", Toast.LENGTH_SHORT).show()
    }


}