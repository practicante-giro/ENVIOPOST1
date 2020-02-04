package com.enviopost.Remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {


    var BASE_URL = "https://www.giro.com.mx/api/checklist/"

    val instance: Checklist by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Checklist::class.java)
    }

}