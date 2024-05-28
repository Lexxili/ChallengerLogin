package com.abraun.challengerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abraun.challengerlogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonLogin.setOnClickListener{
            onLoginClicked()
        }

        binding.buttonSignup.setOnClickListener{
            onSignupClicked()
        }
    }

    private fun onLoginClicked(){
        // check login data
        // go to next page if logged in, if it fails, mark the input fields red and stay at this page
        startActivity(Intent(this, AcceptedActivity::class.java))
    }

    private fun onSignupClicked() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}