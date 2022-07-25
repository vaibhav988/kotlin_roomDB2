package com.example.kotlin_roomdb.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.kotlin_roomdb.database.User
import com.example.kotlin_roomdb.database.DatabaseService
import com.example.kotlin_roomdb.database.UserDao

class UserRepository(context: Context) {

    val allUsers = DatabaseService.getDatabaseInstance(context).userDao().getUsers()
    private val userDao = DatabaseService.getDatabaseInstance(context).userDao()

    fun insertUser(user: User) {
        userDao.addUser(user)
    }

    fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    fun updateUser(user: User) {
        userDao.updateUser(user)
    }

}