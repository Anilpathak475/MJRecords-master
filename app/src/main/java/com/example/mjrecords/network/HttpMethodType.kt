package com.example.mjrecords.network

enum class HttpMethodType private constructor(private val value: String) {
    POST("POST"),
    GET("GET");

    override fun toString(): String {
        return value
    }
}
