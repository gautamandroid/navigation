package com.example.myarea.activity

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myarea.R
import com.example.myarea.databinding.ActivitySingUpBinding

class SingUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySingUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSingup.setOnClickListener {
            var i =Intent(this,EmailVerifyActivity::class.java)
            startActivity(i)

        }

    }
}