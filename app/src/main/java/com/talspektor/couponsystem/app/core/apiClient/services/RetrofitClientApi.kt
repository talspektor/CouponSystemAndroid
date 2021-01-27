package com.talspektor.couponsystem.app.core.apiClient.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientApi {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()

    private val  mBaseUrl = "http://10.0.2.2:8080/api/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(mBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}