package com.example.kotlin_roomdb.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.kotlin_roomdb.databinding.SuccessfulBinding

class UserAddedDialogBox() : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: SuccessfulBinding = SuccessfulBinding.inflate(LayoutInflater.from(context))

        return binding.root.rootView
    }
}