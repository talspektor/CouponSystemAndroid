package com.talspektor.couponsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.talspektor.couponsystem.app.core.apiClient.services.RetrofitClientApi
import com.talspektor.couponsystem.app.core.apiClient.services.adminService.AdminService
import com.talspektor.couponsystem.app.core.beans.Customer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val retrofitClientApi = RetrofitClientApi()
        val retrofit = retrofitClientApi.retrofit

        val service = retrofit.create(AdminService::class.java)
//        val call = service.getCompany(25)
        val call = service.getCustomer(44)
        call.enqueue(object : Callback<Customer> {
            override fun onFailure(call: Call<Customer>, t: Throwable) {
                Log.d("onFailure", "Failure: $t")

            }

            override fun onResponse(call: Call<Customer>, response: Response<Customer>) {
                val customer = response.body()
                customer?.let {
                    print(customer.toString())
//                    textView.text = "First Name: ${customer.firstName}\n" +
//                            "Last Name: ${customer.lastName}\n" +
//                            "Email: ${customer.email}\nPasswprd: ${customer.password}\n" +
//                            "Coupons: ${customer.coupons}"
                }
                Log.d("onResponse", "${response.body()}")
            }

        })
    }
}