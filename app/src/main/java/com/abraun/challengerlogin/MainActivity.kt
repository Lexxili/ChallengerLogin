package com.abraun.challengerlogin

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
    }

    private fun onLoginClicked(){
        // todo check password
        // todo show next screen
    }
}