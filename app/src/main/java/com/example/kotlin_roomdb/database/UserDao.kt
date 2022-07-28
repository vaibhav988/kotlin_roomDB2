package com.example.kotlin_roomdb.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UserDao {

    @Insert
    fun addUser(user: LiveUser)

    @Update
    fun updateUser(user: LiveUser)

    @Delete
    fun deleteUser(user: LiveUser)

    @Query("SELECT * FROM userTable")
    fun getUsers(): LiveData<List<LiveUser>>

}

