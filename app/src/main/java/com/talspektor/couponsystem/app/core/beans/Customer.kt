package com.talspektor.couponsystem.app.core.beans

import com.google.gson.annotations.SerializedName

data class Customer
    (@SerializedName("id")var id: Int,
    @SerializedName("firstName")var firstName: String,
    @SerializedName("lastName")var lastName: String,
    @SerializedName("email")var email: String,
    @SerializedName("password")var password: String,
    @SerializedName("coupons")var coupons: List<Coupon>? = null)
{}
