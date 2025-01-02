package com.example.android_mvvm_room_rest.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Retrofit {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // Log request and response bodies
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)  // Add the logging interceptor to OkHttpClient
        .connectTimeout(30, TimeUnit.SECONDS)  // Optional timeout settings
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Url.BASE_URL)
        .client(okHttpClient)  // Set the OkHttpClient with the interceptor
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var api: ApiInterface = retrofit.create(ApiInterface::class.java)
}
