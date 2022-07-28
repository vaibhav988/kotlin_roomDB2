package com.example.kotlin_roomdb.viewmodel

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_roomdb.repository.UserRepository
import com.example.kotlin_roomdb.database.LiveUser

import com.example.kotlin_roomdb.ui.UserAddedDialogBox
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomViewModel(
    private val userRepository: UserRepository,
    private val supportFragmentManager: FragmentManager,

    ) : ViewModel() {

    var userList = userRepository.allUsers


    fun insertLiveUser(user: LiveUser) {

        if (user.firstName.value.toString().isNotEmpty() && user.lastName.value.toString()
                .isNotEmpty() &&
            user.age.value.toString().isNotEmpty()
        ) {

            viewModelScope.launch(Dispatchers.IO) {
                userRepository.insertUser(user)
            }
            showPopUp()

        }
    }

    private fun showPopUp() {

        val userAddedDialog = UserAddedDialogBox()
        userAddedDialog.show(supportFragmentManager, "t")

    }

    fun deleteLiveUser(user: LiveUser) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.deleteUser(user)
        }
    }


    fun updateLiveUser(user: LiveUser) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.updateUser(user)
        }
    }


}