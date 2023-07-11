package com.example.myarea.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myarea.R
import com.example.myarea.databinding.ActivityEmailVerifyBinding

class EmailVerifyActivity : AppCompatActivity() {

    lateinit var binding: ActivityEmailVerifyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailVerifyBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}