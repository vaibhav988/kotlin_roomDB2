package com.example.kotlin_roomdb.database

import androidx.lifecycle.MutableLiveData
import androidx.room.TypeConverter


class Converter {

    @TypeConverter
    fun mutableStringToSimpleString(mutableString : MutableLiveData<String>): String
    {
        return mutableString.value.toString()
    }
    @TypeConverter
    fun simpleStringToMutableString(simpleString : String): MutableLiveData<String>
    {
        return MutableLiveData<String>(simpleString)
    }

}