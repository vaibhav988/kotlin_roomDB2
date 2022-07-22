package com.example.kotlin_roomdb.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object DatabaseService{

    @Volatile
    private var DatabaseInstance : UserDatabase? = null

    fun getDatabaseInstance(context: Context ):UserDatabase
    {
        if(DatabaseInstance==null) {
            synchronized(this)
            {
                DatabaseInstance = Room.databaseBuilder(
                    context, UserDatabase::class.java,
                    "userDB1"
                ).build()
            }
        }
        return DatabaseInstance!!
    }


}