package com.example.mjrecords.activities

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import com.example.mjrecords.GetXMLTask

import com.example.mjrecords.R
import com.example.mjrecords.adapter.TrackAdapter
import com.example.mjrecords.model.Track
import kotlinx.android.synthetic.main.activity_track_details.*

class TrackDetails : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_details)
        val bundle = intent.extras

        try {
            if (bundle != null) {
                if (bundle.containsKey("trackData")) {
                    val track:Track? = bundle.getParcelable("trackData")
                    init(track = track!!)

                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun init(track: Track) {
        if (!TextUtils.isEmpty(track.artworkUrl100)) {
            GetXMLTask(object : TrackAdapter.CallBackReceiver {
                override fun onSuccess(bitmap: Bitmap) {
                    posterImageView.setImageBitmap(bitmap)
                }
            }).execute(track.artworkUrl100)
        }
        txt_songname!!.text = track.trackName
        txt_artistname!!.text = track.artistName
        txt_releasedate!!.text = track.releaseDate
        txt_genre!!.text = track.primaryGenreName
        txt_country!!.text = track.country
        txt_price!!.text = track.trackPrice
    }
}
