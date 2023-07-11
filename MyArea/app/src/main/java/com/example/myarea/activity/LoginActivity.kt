package com.example.myarea.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myarea.activity.homeActivity.HomeActivity
import com.example.myarea.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSingUp.setOnClickListener {
            var i = Intent(this, SingUpActivity::class.java)
            startActivity(i)

        }
        binding.btLogin.setOnClickListener {
            var i =Intent(this, HomeActivity::class.java)
            startActivity(i)
        }

    }
}