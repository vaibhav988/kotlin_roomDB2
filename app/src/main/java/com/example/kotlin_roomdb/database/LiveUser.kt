package com.example.kotlin_roomdb.database

import androidx.lifecycle.MutableLiveData
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class LiveUser(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: MutableLiveData<String>,
    val lastName: MutableLiveData<String>,
    val age: MutableLiveData<String>


)