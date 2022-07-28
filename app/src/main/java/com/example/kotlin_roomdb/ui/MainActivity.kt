package com.example.kotlin_roomdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_roomdb.database.LiveUser
import com.example.kotlin_roomdb.repository.UserRepository
import com.example.kotlin_roomdb.databinding.ActivityMainBinding
import com.example.kotlin_roomdb.viewmodel.RoomViewModel
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : AppCompatActivity() {

    lateinit var roomDataAdapter: RoomDataAdapter
    lateinit var mainBinding: ActivityMainBinding
    lateinit var roomViewModel: RoomViewModel

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initview()
        setUpDataVaribles()
        observeChange()

    }


    fun initview() {

        roomViewModel = RoomViewModel(UserRepository(this ,mainBinding), supportFragmentManager)
        roomDataAdapter = RoomDataAdapter(applicationContext, supportFragmentManager)

        mainBinding.recycler.apply {
            adapter = roomDataAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }

    }
    fun setUpDataVaribles()
    {
        mainBinding.addUserDia.viewModel = roomViewModel    //setting up the data variable viewmodel
        mainBinding.addUserDia.liveUser = LiveUser(
            0,
            MutableLiveData<String>(""),
            MutableLiveData<String>(""),
            MutableLiveData<String>("")
        )                                            //setting up the data variable liveUser

    }

    fun observeChange()
    {
        roomViewModel.userList.observe(this)    // observing change in the list of liveusers
        {
            roomDataAdapter.submitList(it)

        }
    }
}