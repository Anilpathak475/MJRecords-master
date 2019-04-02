package com.example.mjrecords.network

import android.os.AsyncTask
import android.util.Log
import com.example.mjrecords.activities.MainActivity
import java.io.IOException
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL

internal class HttpTask : AsyncTask<HttpRequest, Void, HttpResponse>() {

    override fun doInBackground(vararg params: HttpRequest): HttpResponse {
        val request = params[0]
        var response: HttpResponse

        try {
            val url = URL(Constants.API_URL)
            val connection = getConnection(url, request.methodType)
            connection.setRequestProperty("Content-Type", "application/json")
            connection.setRequestProperty("Accept", "application/json")

            connection.doOutput = true
            connection.doInput = true
            Log.d("Success  ====>", connection.inputStream.bufferedReader().readLine())

            response = HttpResponse.Builder()
                    .setStatusCode(connection.responseCode)
                    .setBody(connection.inputStream).build()

        } catch (e: IOException) {
            response = HttpResponse.Builder()
                    .setError(Error(e.message))
                    .build()
        }

        return response
    }

    private fun setRequestProperty(connection: HttpURLConnection, additionalHeaders: Map<String, String>?) {
        connection.setRequestProperty("Content-Type", "application/json")
        connection.setRequestProperty("Accept", "application/json")

        if (additionalHeaders == null) {
            return
        }

        for ((key, value) in additionalHeaders) {
            connection.setRequestProperty(key, value)
        }
    }

    private fun setPostRequestArguments(connection: HttpURLConnection) {
        connection.doOutput = true
        connection.setRequestProperty("Content-Type", "application/json; charset=$CONNECTION_CHARSET")
    }

    @Throws(IOException::class)
    private fun writeToOutputStream(outputStream: OutputStream, params: String) {
        outputStream.write(params.toByteArray(charset(CONNECTION_CHARSET)))
        outputStream.flush()
    }

    override fun onPostExecute(result: HttpResponse?) {
        super.onPostExecute(result)

    }

    @Throws(IOException::class)
    private fun getConnection(url: URL, methodType: HttpMethodType): HttpURLConnection {
        val connection = url.openConnection() as HttpURLConnection

        connection.requestMethod = methodType.toString()
        connection.readTimeout = CONNECTION_READ_TIMEOUT
        connection.connectTimeout = CONNECTION_CONNECT_TIMEOUT
        connection.doInput = true
        connection.doOutput = true

        return connection
    }

    companion object {

        val CONNECTION_READ_TIMEOUT = 15000
        val CONNECTION_CONNECT_TIMEOUT = 15000
        private val CONNECTION_CHARSET = "UTF-8"
    }
}
