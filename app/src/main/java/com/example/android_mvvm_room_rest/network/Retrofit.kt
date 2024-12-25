package com.example.android_mvvm_room_rest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Url.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var api: ApiInterface = retrofit.create(ApiInterface::class.java)
}