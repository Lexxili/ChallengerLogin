package com.abraun.challengerlogin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.abraun.challengerlogin.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var user : PersonData
    private lateinit var binding : ActivitySummaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        retrieveUser()
        showUser()
        setupClickListeners()
    }

    private fun retrieveUser(){
        user = intent.getSerializableExtra("Message") as PersonData

    }
    private fun setupClickListeners(){
        binding.buttonCorrect.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.buttonSend.setOnClickListener {
            startActivity(Intent(this, AcceptedActivity::class.java))
        }


        binding.textViewPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user.phone}")
            startActivity(intent)
        }

        binding.textViewEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${user.emailAddress}")
            startActivity(intent)
        }
    }

    private fun showUser(){

        binding.textViewMessage.text = """
            Your personal Data:
           
            ${user.getFullName()}
            ${user.street} ${user.houseNumber}
            ${user.postalCode} ${user.town}
            ${user.country}
        """.trimIndent()

        binding.textViewPhone.text = user.phone
        binding.textViewEmail.text = user.emailAddress

    }



}