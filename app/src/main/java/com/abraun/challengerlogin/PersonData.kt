package com.abraun.challengerlogin

import java.io.Serializable
import java.util.Locale

data class PersonData (
    val firstName: String,
    val lastName: String,
    val street: String,
    val houseNumber: Int,
    val postalCode: Int,
    val town: String,
    val phone: String,
    val country: Locale,
    val emailAddress: String,
    val password: String
    ): Serializable {

        fun getFullName(): String = "$firstName $lastName"
}