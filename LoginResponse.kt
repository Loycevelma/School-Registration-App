package com.example.registration

data class LoginResponse(
    var  email:String,
    var password:String,
    var messages:String,
    @SerializedName("access_token")
    var accessToken:String
)
