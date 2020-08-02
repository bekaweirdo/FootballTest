package com.example.test.data.network

import com.example.test.data.model.StadiumsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface StadiumService {
    @GET("5b9264193300006b00205fb9")
    fun getStadiums(): Call<StadiumsResponse>

    companion object Factory {
        val BASE_URL = "http://www.mocky.io/v2/"
        fun create(): StadiumService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(StadiumService::class.java)
        }
    }
}