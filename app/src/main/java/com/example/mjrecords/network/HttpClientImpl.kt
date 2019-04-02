package com.example.mjrecords.network

import com.example.mjrecords.activities.MainActivity
import java.util.concurrent.ExecutionException

class HttpClientImpl : HttpClient {
    override fun get(url: String, successCallback: HttpClientCallback, failureCallback: HttpClientCallback) {
        val request = HttpRequest.Builder()
                .setUrl(url)
                .setMethodType(HttpMethodType.GET)
                .setSuccessCallback(successCallback)
                .setFailureCallback(failureCallback)
                .build()

        execute(request)

    }

    override fun post(url: String, json: String, additionalHeaders: Map<String, String>, successCallback: HttpClientCallback, failureCallback: HttpClientCallback) {
        val request = HttpRequest.Builder()
                .setUrl(url)
                .setMethodType(HttpMethodType.POST)
                .setParams(json)
                .setAdditionalHeaders(additionalHeaders)
                .setSuccessCallback(successCallback)
                .setFailureCallback(failureCallback)
                .build()

        execute(request)
    }

    private fun execute(request: HttpRequest) {
        val httpTask = HttpTask()
        httpTask.execute(request)


    }
}
