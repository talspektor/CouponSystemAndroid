package com.talspektor.couponsystem.app.core.apiClient.services.interfaces

import retrofit2.Call
import retrofit2.http.GET

interface ClientService {
    @GET("login")
    fun login(email: String, password: String) : Call<Boolean>
}