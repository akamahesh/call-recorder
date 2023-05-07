package com.vdms.composebase.data.local.converter

import androidx.compose.runtime.Stable
import androidx.room.TypeConverter
import com.vdms.composebase.utils.Utility.fromJson
import com.vdms.composebase.utils.Utility.toJson

/**
 * Created by merttoptas on 27.03.2022
 */

@Stable
class EpisodeConverter {
    @TypeConverter
    fun toListOfStrings(stringValue: String): List<String>? {
        return stringValue.fromJson()
    }

    @TypeConverter
    fun fromListOfStrings(listOfString: List<String>?): String {
        return listOfString.toJson()
    }
}

