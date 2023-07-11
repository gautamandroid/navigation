package com.example.myarea.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.myarea.R
import com.example.myarea.databinding.ActivitySplashActivtiyBinding

class SplashActivtiy : AppCompatActivity() {

    lateinit var binding: ActivitySplashActivtiyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashActivtiyBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Handler(Looper.getMainLooper()).postDelayed({

            var i = Intent(this, ViewPagerActivity::class.java)
            startActivity(i)
            finish()

        }, 4000)

    }
}