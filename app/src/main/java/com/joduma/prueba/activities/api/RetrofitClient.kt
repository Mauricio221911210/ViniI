package com.joduma.prueba.activities.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    fun getCliente(url: String): Retrofit {


        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}