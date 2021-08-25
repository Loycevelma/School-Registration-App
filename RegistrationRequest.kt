package com.example.registration

data class RegistrationRequest(
    var name: String,
    @SerializedName("phone_number") var phoneNumber: String,
    var email: String,
    var nationality: String,
    @SerializedName("date_of_birth") var dateOfBirth: String,
    val Dob: String,
    val password: String,
)
