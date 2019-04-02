package com.example.mjrecords.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class TrackModel : Parcelable {

    @Expose
    @SerializedName("results")
    var results: List<Track>? = null
    @Expose
    @SerializedName("resultCount")
    var resultCount: Int = 0


    constructor() {}

    protected constructor(`in`: Parcel) {
        this.results = ArrayList()
        `in`.readList(this.results, Track::class.java!!.getClassLoader())
        this.resultCount = `in`.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(results)
        parcel.writeInt(resultCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TrackModel> {
        override fun createFromParcel(parcel: Parcel): TrackModel {
            return TrackModel(parcel)
        }

        override fun newArray(size: Int): Array<TrackModel?> {
            return arrayOfNulls(size)
        }
    }
}
