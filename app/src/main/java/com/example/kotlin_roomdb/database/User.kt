package com.example.kotlin_roomdb.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class User(
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val firstName: String,
    val lastName: String,
    val age: String
)
