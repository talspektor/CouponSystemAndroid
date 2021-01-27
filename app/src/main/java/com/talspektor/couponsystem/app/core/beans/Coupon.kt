package com.talspektor.couponsystem.app.core.beans

import com.google.gson.annotations.SerializedName
import java.util.*

data class Coupon(
    @SerializedName("id")val id: Int,
    @SerializedName("title")val title: String,
    @SerializedName("company")val company: Company,
    @SerializedName("description")val description: String,
    @SerializedName("startDate")val startDate: Date,
    @SerializedName("endDate")val endDate: Date,
    @SerializedName("amount")val amount: Int,
    @SerializedName("price")val price: Double,
    @SerializedName("category")val category: Category) {}