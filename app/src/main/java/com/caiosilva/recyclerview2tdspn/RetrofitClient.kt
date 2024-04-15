package com.caiosilva.recyclerview2tdspn

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private lateinit var retrofitClient: Retrofit

    fun getRetrofit(url: String): Retrofit {
        retrofitClient = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofitClient
    }
}