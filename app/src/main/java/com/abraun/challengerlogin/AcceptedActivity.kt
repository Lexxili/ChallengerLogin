package com.abraun.challengerlogin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abraun.challengerlogin.databinding.ActivityAcceptedBinding

class AcceptedActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityAcceptedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAcceptedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.textViewInfo.text = "Your request could be processed successfully."

    }
}