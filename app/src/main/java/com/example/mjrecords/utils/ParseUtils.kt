package com.example.mjrecords.utils


import com.example.mjrecords.model.Track
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

import org.json.JSONException
import org.json.JSONObject

import java.util.Collections

class ParseUtils {

    @Throws(JSONException::class)
    fun getTrackFromJson(jsonObject: JSONObject): Track {
        return Track(getValueFromJson(jsonObject, Track.Keys.ISSTREAMABLE),
                getValueFromJson(jsonObject, Track.Keys.PRIMARYGENRENAME),
                getValueFromJson(jsonObject, Track.Keys.CURRENCY),
                getValueFromJson(jsonObject, Track.Keys.COUNTRY),
                getValueFromJson(jsonObject, Track.Keys.TRACKTIMEMILLIS),
                getValueFromJson(jsonObject, Track.Keys.TRACKNUMBER),
                getValueFromJson(jsonObject, Track.Keys.TRACKCOUNT),
                getValueFromJson(jsonObject, Track.Keys.DISCNUMBER),
                getValueFromJson(jsonObject, Track.Keys.TRACKEXPLICITNESS),
                getValueFromJson(jsonObject, Track.Keys.COLLECTIONEXPLICITNESS),
                getValueFromJson(jsonObject, Track.Keys.RELEASEDATE),
                getValueFromJson(jsonObject, Track.Keys.TRACKPRICE),
                getValueFromJson(jsonObject, Track.Keys.COLLECTIONPRICE),
                getValueFromJson(jsonObject, Track.Keys.ARTWORKURL100),
                getValueFromJson(jsonObject, Track.Keys.ARTWORKURL60),
                getValueFromJson(jsonObject, Track.Keys.ARTWORKURL30),
                getValueFromJson(jsonObject, Track.Keys.PREVIEWURL),
                getValueFromJson(jsonObject, Track.Keys.TRACKVIEWURL),
                getValueFromJson(jsonObject, Track.Keys.COLLECTIONVIEWURL),
                getValueFromJson(jsonObject, Track.Keys.ARTISTVIEWURL),
                getValueFromJson(jsonObject, Track.Keys.COLLECTIONARTISTVIEWURL),
                getValueFromJson(jsonObject, Track.Keys.COLLECTIONARTISTNAME),
                getValueFromJson(jsonObject, Track.Keys.COLLECTIONARTISTID),
                getValueFromJson(jsonObject, Track.Keys.TRACKCENSOREDNAME),
                getValueFromJson(jsonObject, Track.Keys.COLLECTIONCENSOREDNAME),
                getValueFromJson(jsonObject, Track.Keys.TRACKNAME),
                getValueFromJson(jsonObject, Track.Keys.COLLECTIONNAME),
                getValueFromJson(jsonObject, Track.Keys.ARTISTNAME),
                getValueFromJson(jsonObject, Track.Keys.TRACKID),
                getValueFromJson(jsonObject, Track.Keys.COLLECTIONID),
                getValueFromJson(jsonObject, Track.Keys.ARTISTID),
                getValueFromJson(jsonObject, Track.Keys.KIND)
        )
    }

    private fun getValueFromJson(jsonObject: JSONObject, key: String): String {
        if (jsonObject.has(key)) return jsonObject.getString(key)
        return ""
    }

    companion object {

        val instance: ParseUtils
            get() = ParseUtils()
    }
}
