package com.app.flickr.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.flickr.com/services/"

    val api: FlickrApi by lazy {
        try {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FlickrApi::class.java)
        } catch (e: Exception){
            throw RuntimeException("Failed to create Retrofit instance", e)
        }
    }
}