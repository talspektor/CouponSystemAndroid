package com.talspektor.couponsystem.app.core.apiClient.services


class ApiServiceResult<T>(t: T) {
    val objects = t
    val error: Error? = null


}