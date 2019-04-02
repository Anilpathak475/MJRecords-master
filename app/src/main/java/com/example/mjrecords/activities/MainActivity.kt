package com.example.mjrecords.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.mjrecords.GerRequest
import com.example.mjrecords.adapter.TrackAdapter
import com.example.mjrecords.model.Track
import com.example.mjrecords.network.Constants
import com.example.mjrecords.utils.ParseUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity(), TrackAdapter.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.mjrecords.R.layout.activity_main)
        init()
    }

    private fun init() {
        fetchMJTracks()
    }

    private fun fetchMJTracks() {
        GerRequest(object : CallBackReceiver {
            override fun onSuccess(response: String) {
                createListFromJson(response)
            }
        }).execute(Constants.API_URL)
    }

    private fun createListFromJson(jsonString: String) {
        try {
            val data = JSONObject(jsonString)
            val tracks: MutableList<Track> = mutableListOf()
            val trackArray = data.getJSONArray("results")
            for (i in 0..(trackArray.length() - 1)) {
                val item = trackArray.getJSONObject(i)
                val track = ParseUtils.instance.getTrackFromJson(item)
                tracks.add(track)
            }
            setAdapter(tracks)
        } catch (ex: Exception) {
            Log.d("Error", ex.localizedMessage)
        }
    }

    private fun setAdapter(tracks: List<Track>?) {
        val adapter = TrackAdapter(tracks, this)
        trackRecyclerView.adapter = adapter
        progressBar.visibility= View.GONE
        trackRecyclerView.visibility = View.VISIBLE
    }

    override fun onChildClick(track: Track) {
        val bundle = Bundle()
        bundle.putParcelable("trackData", track)
        val intent = Intent(this@MainActivity, TrackDetails::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }


    interface CallBackReceiver {
        fun onSuccess(response: String)
    }

}
