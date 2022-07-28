package com.example.kotlin_roomdb.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.kotlin_roomdb.database.LiveUser
import com.example.kotlin_roomdb.repository.UserRepository
import com.example.kotlin_roomdb.databinding.UsereditdialogBinding
import com.example.kotlin_roomdb.viewmodel.RoomViewModel


class UserUpdateDialogBox(
    context: Context,
    val user: LiveUser,
    private val supportFragmentManager: FragmentManager
) : DialogFragment() {

      val roomViewModel: RoomViewModel =
        RoomViewModel(UserRepository(context, null), supportFragmentManager)

    lateinit var binding: UsereditdialogBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = UsereditdialogBinding.inflate(LayoutInflater.from(context))
        binding.liveUser = user        // setting up the data variable liveuser
        binding.diaLogBox = this      // setting up the data variables dialogbox
        this.isCancelable= true
        return binding.root.rootView

    }
    fun updateCurrentUser(user : LiveUser)
    {

        roomViewModel.updateLiveUser(user)
        this.dismiss()
    }


    fun showDialog() {

        this.show(supportFragmentManager, "t")

    }

}