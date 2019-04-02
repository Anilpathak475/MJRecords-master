package com.example.mjrecords.adapter

import android.graphics.Bitmap
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.mjrecords.GetXMLTask
import com.example.mjrecords.model.Track


class TrackAdapter(private val trackList: List<Track>?, private val listener: Listener) : RecyclerView.Adapter<TrackAdapter.ViewTrackViewHolder>() {
    private var isPlaying = false

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewTrackViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.mjrecords.R.layout.tracks_list_row_item,
                parent, false)
        return ViewTrackViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewTrackViewHolder, i: Int) {
        val trackModel = trackList!![viewHolder.adapterPosition]
        if (!TextUtils.isEmpty(trackModel.artworkUrl100)) {
            viewHolder.progressBar.visibility = View.VISIBLE
            viewHolder.trackImage.visibility = View.INVISIBLE
            GetXMLTask(object : CallBackReceiver {
                override fun onSuccess(bitmap: Bitmap) {
                    viewHolder.trackImage.setImageBitmap(bitmap)
                    viewHolder.progressBar.visibility = View.GONE
                    viewHolder.trackImage.visibility = View.VISIBLE

                }
            }).execute(trackModel.artworkUrl100)
        }

        if (!TextUtils.isEmpty(trackModel.trackName)) {
            viewHolder.trackName.text = trackModel.trackName
        } else {
            viewHolder.trackName.text = ""
        }
        if (!TextUtils.isEmpty(trackModel.artistName)) {
            viewHolder.artistName.text = trackModel.artistName
        } else {
            viewHolder.artistName.text = ""
        }
        if (trackModel.collectionName != null) {
            if (!TextUtils.isEmpty(trackModel.collectionName)) {
                viewHolder.collectionName.text = trackModel.collectionName
            } else {
                viewHolder.collectionName.text = ""
            }
        }
        viewHolder.trackCardview.setOnClickListener { listener.onChildClick(trackModel) }
    }


    override fun getItemCount(): Int {
        return trackList!!.size
    }

    inner class ViewTrackViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var trackImage: ImageView
        var trackName: TextView
        var artistName: TextView
        var collectionName: TextView
        var trackCardview: CardView
        var progressBar: ProgressBar


        init {
            progressBar = view.findViewById(com.example.mjrecords.R.id.progressBar)
            trackImage = view.findViewById(com.example.mjrecords.R.id.track_cover_image)
            trackName = view.findViewById(com.example.mjrecords.R.id.track_name)
            artistName = view.findViewById(com.example.mjrecords.R.id.artist_name)
            collectionName = view.findViewById(com.example.mjrecords.R.id.collectionName)
            trackCardview = view.findViewById(com.example.mjrecords.R.id.track_view_card)
        }
    }

    interface Listener {
        fun onChildClick(track: Track)
    }


    interface CallBackReceiver {
        fun onSuccess(bitmap: Bitmap)
    }
}
