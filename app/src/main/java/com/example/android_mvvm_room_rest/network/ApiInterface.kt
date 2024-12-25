package com.example.android_mvvm_room_rest.network

import com.example.android_mvvm_room_rest.model.Item
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products/")
    fun getProductList() : Call<List<Item>>
}