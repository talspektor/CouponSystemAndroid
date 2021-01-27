package com.talspektor.couponsystem.app.core.apiClient.services.adminService

import com.talspektor.couponsystem.app.core.apiClient.services.interfaces.ClientService
import com.talspektor.couponsystem.app.core.beans.Company
import com.talspektor.couponsystem.app.core.beans.Customer
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface AdminService:
    ClientService {
    @GET("companies")
    fun getCompanies() : Call<List<Company>>
    @GET("customers")
    fun getCustomers() : Call<List<Customer>>
    @POST("add-company")
    fun addCompany(@Body company: JSONObject) : Call<Boolean>
    @PUT("update-company")
    fun updateCompany(@Body company: JSONObject) : Call<Boolean>
    @PUT("delete-company/{id}")
    fun deleteCompany(@Path("id") id: Int) : Call<Boolean>
    @GET("company/{id}")
    fun getCompany(@Path("id") id: Int) : Call<Company>
    @POST("add-customer")
    fun addCustomer(@Body customer: Customer) : Call<Boolean>
    @PUT("update-customer")
    fun updateCustomer(@Body customer: Customer) : Call<Boolean>
    @PUT("delete-customer/{id}")
    fun deleteCustomer(@Path("id") id: Int) : Call<Boolean>
    @GET("customer/{id}")
    fun getCustomer(@Path("id") id: Int) : Call<Customer>
}