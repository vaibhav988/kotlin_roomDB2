package com.example.kotlin_roomdb.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [LiveUser::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}