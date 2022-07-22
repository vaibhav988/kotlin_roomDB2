package com.example.kotlin_roomdb.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.kotlin_roomdb.database.User
import com.example.kotlin_roomdb.database.DatabaseService
import com.example.kotlin_roomdb.database.UserDao

class UserRepository(val context: Context) {
     var allUsers : LiveData<List<User>>
     var userDao : UserDao

    init {
        allUsers = DatabaseService.getDatabaseInstance(context).userDao().getUsers()
        userDao = DatabaseService.getDatabaseInstance(context).userDao()
    }

      fun insertUser(user : User)
    {
        userDao.addUser(user)
    }

    fun deleteUser(user : User)
    {
        userDao.deleteUser(user)
    }

     fun updateUser(user: User)
    {
        userDao.updateUser(user)
    }

}