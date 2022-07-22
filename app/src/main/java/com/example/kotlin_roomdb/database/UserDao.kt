package com.example.kotlin_roomdb.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert
     fun addUser(user : User)

    @Update
       fun updateUser(user : User)

    @Delete
     fun deleteUser(user : User)

    @Query("select * from userTable")
      fun getUsers() : LiveData<List<User>>

}