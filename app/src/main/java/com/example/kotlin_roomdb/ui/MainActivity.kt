package com.example.kotlin_roomdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_roomdb.repository.UserRepository
import com.example.kotlin_roomdb.database.User
import com.example.kotlin_roomdb.databinding.ActivityMainBinding

import com.example.kotlin_roomdb.viewmodel.Roomviewmodel
import kotlinx.coroutines.DelicateCoroutinesApi

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var roomDataAdapter: RoomDataAdapter
    lateinit var binding: ActivityMainBinding
    lateinit var roomviewmodel: Roomviewmodel

    @OptIn(DelicateCoroutinesApi::class)
    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()

        binding.addUserDia.addUserBtn.setOnClickListener({

            addUserOnclick()

        })
    }

    fun initview()
    {
        roomviewmodel = Roomviewmodel(UserRepository(this))
        roomDataAdapter = RoomDataAdapter(applicationContext , supportFragmentManager)
        binding.recycler.apply {

            adapter  = roomDataAdapter
            layoutManager = LinearLayoutManager(applicationContext)

        }
        roomviewmodel.userList.observe(this , {
            roomDataAdapter.submitList(it)
        })
    }

     @OptIn(DelicateCoroutinesApi::class)
      fun addUserOnclick()
    {
        if(binding.addUserDia.editFname.text.toString().length ==0)
        {
            binding.addUserDia.editFname.setError("Please fill it")
            return
        }
        else if(binding.addUserDia.editLname.text.toString().length==0)
        {
            binding.addUserDia.editLname.setError("Please fill it")
            return
        }
        else if(binding.addUserDia.editAge.text.toString().length==0)
        {
            binding.addUserDia.editAge.setError("Please fill it")
            return
        }
        else {
            val fname = binding.addUserDia.editFname.text.toString()
            val lname = binding.addUserDia.editLname.text.toString()
            val age =  binding.addUserDia.editAge.text.toString()

                roomviewmodel.insertUser(
                    User(0, fname , lname , age )
                )

            Toast.makeText(
                applicationContext,
                "User has been added to Room database",
                Toast.LENGTH_SHORT
            ).show()
            binding.addUserDia.editFname.setText("")
            binding.addUserDia.editLname.setText("")
            binding.addUserDia.editAge.setText("")

        }

    }
}