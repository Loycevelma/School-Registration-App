package com.example.registration

import android.telecom.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiInterface {
        @POST("/students/register")
        suspend fun registerStudent(@Body registrationRequest:RegistrationRequest):Response<RegistrationResponse>

        @POST("/students/login")
        fun studentLogin(@Body loginRequest: LoginRequest): Response<LoginResponse>
    }




