package com.example.kotlin_roomdb.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.kotlin_roomdb.repository.UserRepository
import com.example.kotlin_roomdb.database.User
import com.example.kotlin_roomdb.databinding.AddUserBinding
import com.example.kotlin_roomdb.databinding.UsereditdialogBinding
import com.example.kotlin_roomdb.viewmodel.Roomviewmodel

class DialogBox(context: Context ,val user : User) : DialogFragment(){


    val roomviewmodel: Roomviewmodel = Roomviewmodel(UserRepository(context))
    lateinit var binding: UsereditdialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
         binding = UsereditdialogBinding.inflate(LayoutInflater.from(context))
         setPrperties()
         return binding.root.rootView
    }

    fun setPrperties()
    {
        binding.dialogAge.setText(user.age)
        binding.diaFname.setText(user.firstName)
        binding.diaLname.setText(user.lastName)


        binding.UpdateUserbtn.setOnClickListener({

            roomviewmodel.updateUser(
                User(user
                    .Id , binding.diaFname.text.toString(), binding.diaLname.text.toString(),
                    binding.dialogAge.text.toString() )
            )
            dismiss()
        })
    }
}