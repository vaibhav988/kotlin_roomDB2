package com.example.kotlin_roomdb.repository

import android.content.Context
import com.example.kotlin_roomdb.database.DatabaseService
import com.example.kotlin_roomdb.database.LiveUser
import com.example.kotlin_roomdb.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserRepository(context: Context, private val mainBinding: ActivityMainBinding?) {

    val allUsers = DatabaseService.getDatabaseInstance(context).userDao().getUsers()
    private val userDao = DatabaseService.getDatabaseInstance(context).userDao()

    @OptIn(DelicateCoroutinesApi::class)
    fun insertUser(user: LiveUser) {
        userDao.addUser(user)
        GlobalScope.launch(Dispatchers.Main) {
            mainBinding?.addUserDia?.editFname?.setText("")
            mainBinding?.addUserDia?.editAge?.setText("")
            mainBinding?.addUserDia?.editLname?.setText("")
        }
    }

    fun deleteUser(user: LiveUser) {
        userDao.deleteUser(user)
    }

    fun updateUser(user: LiveUser) {
        userDao.updateUser(user)
    }

}