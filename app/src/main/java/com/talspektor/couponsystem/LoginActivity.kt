package com.talspektor.couponsystem

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.talspektor.couponsystem.app.core.apiClient.services.RetrofitClientApi
import com.talspektor.couponsystem.app.core.apiClient.services.adminService.AdminService
import com.talspektor.couponsystem.app.core.beans.Customer
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "LoginActivity"
    }

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Tools.setSystemBarLight(this)
        Tools.setSystemBarColor(this, R.color.white)

        signinButton.setOnClickListener {
            val inputEmail = emailTextField.text.toString()
            val inputPassword = passwordTextField.text.toString()
            if (inputEmail != null && inputEmail.isNotEmpty() && inputPassword != null && inputPassword.isNotEmpty()) {
                createUser(inputEmail, inputPassword)
            }
        }
    }

    private fun signIn(email: String, password: String) {

    }

    private fun createUser(email: String, password: String) {
        val retrofitClientApi = RetrofitClientApi()
        val retrofit = retrofitClientApi.retrofit

        val service = retrofit.create(AdminService::class.java)
        val customer: Customer = Customer(1, "androidName", "android", "android@email", "aPass")
        val call = service.addCustomer(customer)

        call.enqueue(object : Callback<Boolean> {
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                Log.d("onFailure", "Failure: $t")

            }

            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                Log.d("onResponse", "${response.body()}")
            }

        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }
}
