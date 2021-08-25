package com.example.registration

import android.app.TaskStackBuilder.create
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URI.create

object ApiClient {
        var retrofit= Retrofit.Builder()
                .baseUrl("http://13.244.243.129")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        fun <T> buildApiClient(ApiInterface:Class<T>):T{
            return retrofit.create(ApiInterface)
        }

    }

