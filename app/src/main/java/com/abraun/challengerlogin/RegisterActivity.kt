package com.abraun.challengerlogin

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.abraun.challengerlogin.databinding.ActivityRegisterBinding
import java.util.Locale

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonCreateAccount.setOnClickListener {
            onCreateClicked()
        }

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayOf(
                Locale.getAvailableLocales()))
        binding.spinnerCountry.adapter = spinnerAdapter
    }

    private fun onCreateClicked() {
        val personData = PersonData(binding.editTextFirstName.text.toString(),
            binding.editTextLastName.text.toString(),
            binding.editTextStreet.text.toString(),
            binding.editTextHouseNumber.text.toString().toInt(),
            binding.editTextPostalCode.text.toString().toInt(),
            binding.editTextTown.text.toString(),
            // todo prüfung einbauen für null pointer
            Locale(binding.spinnerCountry.selectedItem.toString()),
            binding.editTextEmail.text.toString(),
            binding.editTextPassword.text.toString())
    }
}