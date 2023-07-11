package com.example.myarea.fragment.messageFragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myarea.R
import com.example.myarea.databinding.FragmentChatBinding
import com.example.myarea.fragment.messageFragment.adapter.ChatAdepter
import com.example.myarea.modal.DataChatAdepter

class ChatFragment : Fragment() {

    lateinit var binding: FragmentChatBinding
    lateinit var chatAdepter: ChatAdepter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        chatAdepter = ChatAdepter(requireContext(), getListOfData(requireContext()))
        binding.reMessage.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.reMessage.adapter = chatAdepter


    }

    fun getListOfData(context: Context): ArrayList<DataChatAdepter> {
        var items = ArrayList<DataChatAdepter>()

        items.add(DataChatAdepter("Veranda Restaurant", "hello dear", R.drawable.im_chat_m))
        items.add(DataChatAdepter("LA Restaurant", "Hie !!!", R.drawable.im_chat_house, 8, 3))
        items.add(DataChatAdepter("Kabuki Restaurant", "Hie !!!", R.drawable.im_chat_open))
        items.add(DataChatAdepter("Locke Restaurant ", "Hie !!!", R.drawable.im_chat_food))
        items.add(DataChatAdepter("Sushi Restaurant ", "Hie !!!", R.drawable.im_chat_open, 8, 3))
        items.add(DataChatAdepter(" Huddle Restaurant ", "Hie !!!", R.drawable.im_chat_m))

        return items

    }

}