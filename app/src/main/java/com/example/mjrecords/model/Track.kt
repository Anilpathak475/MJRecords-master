package com.example.mjrecords.model

import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class Track constructor(
        var isStreamable: String? = null,
        var primaryGenreName: String? = null,
        var currency: String? = null,
        var country: String? = null,
        var trackTimeMillis: String? = null,
        var trackNumber: String? = null,
        var trackCount: String? = null,
        var discNumber: String? = null,
        var discCount: String? = null,
        var trackExplicitness: String? = null,
        var collectionExplicitness: String? = null,
        var releaseDate: String? = null,
        var trackPrice: String? = null,
        var collectionPrice: String? = null,
        var artworkUrl100: String? = null,
        var artworkUrl60: String? = null,
        var artworkUrl30: String? = null,
        var previewUrl: String? = null,
        var trackViewUrl: String? = null,
        var collectionViewUrl: String? = null,
        var artistViewUrl: String? = null,
        var collectionArtistViewUrl: String? = null,
        var collectionArtistName: String? = null,
        var collectionArtistId: String? = null,
        var trackCensoredName: String? = null,
        var collectionCensoredName: String? = null,
        var trackName: String? = null,
        var collectionName: String? = null,
        var artistName: String? = null,
        var trackId: String? = null,
        var collectionId: String? = null,
        var artistId: String? = null,
        var kind: String? = null,
        var wrapperType: String? = null) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    constructor(jsonObject: JSONObject) : this() {
        Track(getValueFromJson(jsonObject, Keys.ISSTREAMABLE),
                getValueFromJson(jsonObject, Keys.PRIMARYGENRENAME),
                getValueFromJson(jsonObject, Keys.CURRENCY),
                getValueFromJson(jsonObject, Keys.COUNTRY),
                getValueFromJson(jsonObject, Keys.TRACKTIMEMILLIS),
                getValueFromJson(jsonObject, Keys.TRACKNUMBER),
                getValueFromJson(jsonObject, Keys.TRACKCOUNT),
                getValueFromJson(jsonObject, Keys.DISCNUMBER),
                getValueFromJson(jsonObject, Keys.TRACKEXPLICITNESS),
                getValueFromJson(jsonObject, Keys.COLLECTIONEXPLICITNESS),
                getValueFromJson(jsonObject, Keys.RELEASEDATE),
                getValueFromJson(jsonObject, Keys.TRACKPRICE),
                getValueFromJson(jsonObject, Keys.COLLECTIONPRICE),
                getValueFromJson(jsonObject, Keys.ARTWORKURL100),
                getValueFromJson(jsonObject, Keys.ARTWORKURL60),
                getValueFromJson(jsonObject, Keys.ARTWORKURL30),
                getValueFromJson(jsonObject, Keys.PREVIEWURL),
                getValueFromJson(jsonObject, Keys.TRACKVIEWURL),
                getValueFromJson(jsonObject, Keys.COLLECTIONVIEWURL),
                getValueFromJson(jsonObject, Keys.ARTISTVIEWURL),
                getValueFromJson(jsonObject, Keys.COLLECTIONARTISTVIEWURL),
                getValueFromJson(jsonObject, Keys.COLLECTIONARTISTNAME),
                getValueFromJson(jsonObject, Keys.COLLECTIONARTISTID),
                getValueFromJson(jsonObject, Keys.TRACKCENSOREDNAME),
                getValueFromJson(jsonObject, Keys.COLLECTIONCENSOREDNAME),
                getValueFromJson(jsonObject, Keys.TRACKNAME),
                getValueFromJson(jsonObject, Keys.COLLECTIONNAME),
                getValueFromJson(jsonObject, Keys.ARTISTNAME),
                getValueFromJson(jsonObject, Keys.TRACKID),
                getValueFromJson(jsonObject, Keys.COLLECTIONID),
                getValueFromJson(jsonObject, Keys.ARTISTID),
                getValueFromJson(jsonObject, Keys.KIND)
        )
    }

    internal object Keys {
        var ISSTREAMABLE = "isStreamable"
        var PRIMARYGENRENAME = "primaryGenreName"
        var CURRENCY = "currency"
        var COUNTRY = "country"
        var TRACKTIMEMILLIS = "trackTimeMillis"
        var TRACKNUMBER = "trackNumber"
        var TRACKCOUNT = "trackCount"
        var DISCNUMBER = "discNumber"
        var DISCCOUNT = "discCount"
        var TRACKEXPLICITNESS = "trackExplicitness"
        var COLLECTIONEXPLICITNESS = "collectionExplicitness"
        var RELEASEDATE = "releaseDate"
        var TRACKPRICE = "trackPrice"
        var COLLECTIONPRICE = "collectionPrice"
        var ARTWORKURL100 = "artworkUrl100"
        var ARTWORKURL60 = "artworkUrl60"
        var ARTWORKURL30 = "artworkUrl30"
        var PREVIEWURL = "previewUrl"
        var TRACKVIEWURL = "trackViewUrl"
        var COLLECTIONVIEWURL = "collectionViewUrl"
        var ARTISTVIEWURL = "artistViewUrl"
        var COLLECTIONARTISTVIEWURL = "collectionArtistViewUrl"
        var COLLECTIONARTISTNAME = "collectionArtistName"
        var COLLECTIONARTISTID = "collectionArtistId"
        var TRACKCENSOREDNAME = "trackCensoredName"
        var COLLECTIONCENSOREDNAME = "collectionCensoredName"
        var TRACKNAME = "trackName"
        var COLLECTIONNAME = "collectionName"
        var ARTISTNAME = "artistName"
        var TRACKID = "trackId"
        var COLLECTIONID = "collectionId"
        var ARTISTID = "artistId"
        var KIND = "kind"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(isStreamable)
        parcel.writeString(primaryGenreName)
        parcel.writeString(currency)
        parcel.writeString(country)
        parcel.writeString(trackTimeMillis)
        parcel.writeString(trackNumber)
        parcel.writeString(trackCount)
        parcel.writeString(discNumber)
        parcel.writeString(discCount)
        parcel.writeString(trackExplicitness)
        parcel.writeString(collectionExplicitness)
        parcel.writeString(releaseDate)
        parcel.writeString(trackPrice)
        parcel.writeString(collectionPrice)
        parcel.writeString(artworkUrl100)
        parcel.writeString(artworkUrl60)
        parcel.writeString(artworkUrl30)
        parcel.writeString(previewUrl)
        parcel.writeString(trackViewUrl)
        parcel.writeString(collectionViewUrl)
        parcel.writeString(artistViewUrl)
        parcel.writeString(collectionArtistViewUrl)
        parcel.writeString(collectionArtistName)
        parcel.writeString(collectionArtistId)
        parcel.writeString(trackCensoredName)
        parcel.writeString(collectionCensoredName)
        parcel.writeString(trackName)
        parcel.writeString(collectionName)
        parcel.writeString(artistName)
        parcel.writeString(trackId)
        parcel.writeString(collectionId)
        parcel.writeString(artistId)
        parcel.writeString(kind)
        parcel.writeString(wrapperType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Track> {
        override fun createFromParcel(parcel: Parcel): Track {
            return Track(parcel)
        }

        override fun newArray(size: Int): Array<Track?> {
            return arrayOfNulls(size)
        }
    }

    private fun getValueFromJson(jsonObject: JSONObject, key: String): String {
        if (jsonObject.has(key)) return jsonObject.getString(key)
        return ""
    }
}



