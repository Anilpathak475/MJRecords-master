package com.example.mjrecords;

import android.os.AsyncTask;

import com.example.mjrecords.activities.MainActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GerRequest extends AsyncTask<String, Void, String> {
    private MainActivity.CallBackReceiver addressCallback;

    public GerRequest(MainActivity.CallBackReceiver addressCallback) {
        this.addressCallback = addressCallback;
    }

    @Override
    protected String doInBackground(String... strings) {
        StringBuffer response = null;
        try {
            URL obj = new URL(strings[0]);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert response != null;
        return response.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        addressCallback.onSuccess(s);
    }
}