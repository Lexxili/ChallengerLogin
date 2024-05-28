package com.abraun.challengerlogin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abraun.challengerlogin.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySummaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonCorrect.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.buttonSend.setOnClickListener {
            startActivity(Intent(this, AcceptedActivity::class.java))
        }

        showSummary()
    }

    private fun showSummary(){
        var personData = intent.getSerializableExtra("Message") as PersonData
        val summaryText = """
            Your personal Data:
            
            ${personData.getFullName()}
            ${personData.street} ${personData.houseNumber}
            ${personData.postalCode} ${personData.town}
            
            in ${personData.country}.
            
            You will be registered with your E-mail:
            
            ${personData.emailAddress}
            
            and the password:
            
            ${personData.password}
            
        """.trimIndent()

        binding.textViewMessage.text = summaryText
    }

}