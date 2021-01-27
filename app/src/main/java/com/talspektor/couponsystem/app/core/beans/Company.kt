package com.talspektor.couponsystem.app.core.beans

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Company {
    @SerializedName("id")var id: Int? = null
    @SerializedName("name")var name: String? = null
    @SerializedName("email")var email: String? = null
    @SerializedName("password")var password: String? = null
//    @SerializedName("coupons")var coupons: List<Coupon>? = null
}
