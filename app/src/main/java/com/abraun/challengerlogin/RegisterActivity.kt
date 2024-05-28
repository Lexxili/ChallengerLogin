package com.abraun.challengerlogin

import android.content.Intent
import android.icu.text.LocaleDisplayNames
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

        //fillCountrySpinner()
        setCountry()


    }

    private fun onCreateClicked() {
        val personData = PersonData(binding.editTextFirstName.text.toString(),
            binding.editTextLastName.text.toString(),
            binding.editTextStreet.text.toString(),
            binding.editTextHouseNumber.text.toString().toInt(),
            binding.editTextPostalCode.text.toString().toInt(),
            binding.editTextTown.text.toString(),
            // todo prüfung einbauen für null pointer
            Locale(binding.autoCompleteTextViewCountry.text.toString()),
            //Locale(binding.spinnerCountry.selectedItem.toString()),
            binding.editTextEmail.text.toString(),
            binding.editTextPassword.text.toString())

        val summaryActivityIntent = Intent(this, SummaryActivity::class.java)
        summaryActivityIntent.putExtra("Message", personData)
        startActivity(summaryActivityIntent)
    }

    private fun fillCountrySpinner(){
        // searches the system language
        val locale = Locale.getDefault()

        // finds the country names
        val countryNames = Locale.getISOCountries().map { countryCode ->
            Locale("", countryCode).getDisplayCountry(locale)
        }.sorted()


        // sets the names in the spinner
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,
            countryNames)

        //binding.spinnerCountry.adapter = spinnerAdapter
    }

    private fun setCountry(){
        // searches the system language
        val locale = Locale.getDefault()

        // finds the country names
        val countryNames = Locale.getISOCountries().map { countryCode ->
            Locale("", countryCode).getDisplayCountry(locale)
        }.sorted()


        // sets the names in the spinner
        val dropdownAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,
            countryNames)

        binding.autoCompleteTextViewCountry.setAdapter(dropdownAdapter)

        binding.autoCompleteTextViewCountry.setOnClickListener {
            binding.autoCompleteTextViewCountry.showDropDown()
        }
    }
}