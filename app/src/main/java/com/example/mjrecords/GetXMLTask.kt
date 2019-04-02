package com.example.mjrecords

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import com.example.mjrecords.adapter.TrackAdapter
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class GetXMLTask(val callBackReceiver: TrackAdapter.CallBackReceiver) : AsyncTask<String, Void, Bitmap>() {
        override fun doInBackground(vararg urls: String): Bitmap? {
            var map: Bitmap? = null
            for (url in urls) {
                map = downloadImage(url)
            }
            return map
        }

        // Sets the Bitmap returned by doInBackground
        override fun onPostExecute(result: Bitmap) {
            callBackReceiver.onSuccess(result)
        }

        // Creates Bitmap from InputStream and returns it
        private fun downloadImage(url: String): Bitmap? {
            var bitmap: Bitmap? = null
            var stream: InputStream? = null
            val bmOptions = BitmapFactory.Options()
            bmOptions.inSampleSize = 1

            try {
                stream = getHttpConnection(url)
                bitmap = BitmapFactory.decodeStream(stream, null, bmOptions)
                stream!!.close()
            } catch (e1: IOException) {
                e1.printStackTrace()
            }

            return bitmap
        }

        // Makes HttpURLConnection and returns InputStream
        @Throws(IOException::class)
        private fun getHttpConnection(urlString: String): InputStream? {
            var stream: InputStream? = null
            val url = URL(urlString)
            val connection = url.openConnection()

            try {
                val httpConnection = connection as HttpURLConnection
                httpConnection.requestMethod = "GET"
                httpConnection.connect()

                if (httpConnection.responseCode == HttpURLConnection.HTTP_OK) {
                    stream = httpConnection.inputStream
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }

            return stream
        }
    }