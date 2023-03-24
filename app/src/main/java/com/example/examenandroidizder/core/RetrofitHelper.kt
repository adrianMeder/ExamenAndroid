package com.example.examenandroidizder.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://d4qo4rsz5l.execute-api.us-east-1.amazonaws.com/dev/album/list")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}