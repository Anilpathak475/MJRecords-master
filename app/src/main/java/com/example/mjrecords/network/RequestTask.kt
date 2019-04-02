package com.example.mjrecords.network

import android.app.Activity
import android.app.ProgressDialog
import android.content.SharedPreferences
import android.os.AsyncTask
import com.example.mjrecords.activities.MainActivity
import java.io.BufferedInputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.ProtocolException
import java.net.URL
import javax.security.auth.callback.Callback

class RequestTask(val callback: MainActivity.CallBackReceiver) : AsyncTask<String, String, String>() {
    //  private String url = "https://121.240.9.17/bows/"+MethodName+"/"+ ConstantsNew.PRAN; //current
    // private String url = "https://121.240.246.11/bows/"+MethodName+"/"+ ConstantsNew.PRAN;
    private val mProgressDialog: ProgressDialog? = null
    internal var sp: SharedPreferences? = null
    internal var progressDialog: ProgressDialog? = null
    internal var spe: SharedPreferences.Editor? = null

    override fun onPreExecute() {
        super.onPreExecute()

    }


    override fun doInBackground(vararg uri: String): String {

        //time out code
        var response = ""

        try {
            val url = URL(uri[0])
            val urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.doInput = true
            urlConnection.doOutput = true
            urlConnection.requestMethod = HttpMethodType.GET.toString()
            val statusCode = urlConnection.responseCode
            if (statusCode == 200) {
                val inputStream = BufferedInputStream(urlConnection.inputStream)
                response = inputStream.bufferedReader().readLine().toString()
            }
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: ProtocolException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return response
    }

    override fun onProgressUpdate(vararg progress: String) {}

    override fun onPostExecute(result: String) {
      //  callback.onSuccess(result)
    }


    override fun onCancelled() {
        super.onCancelled()
    }




}
    
