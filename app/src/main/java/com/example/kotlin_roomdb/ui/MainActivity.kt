package com.example.kotlin_roomdb.ui
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_roomdb.repository.UserRepository
import com.example.kotlin_roomdb.database.User
import com.example.kotlin_roomdb.databinding.ActivityMainBinding
import com.example.kotlin_roomdb.viewmodel.RoomViewModel
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : AppCompatActivity() {

    lateinit var roomDataAdapter: RoomDataAdapter
    lateinit var mainBinding: ActivityMainBinding
    lateinit var roomViewModel: RoomViewModel

    @OptIn(DelicateCoroutinesApi::class)
    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initview()

        mainBinding.addUserDia.addUserBtn.setOnClickListener {
            addUserOnclick()
        }
    }
    fun initview()
    {
        roomViewModel = RoomViewModel(UserRepository(this))
        roomDataAdapter = RoomDataAdapter(applicationContext ,supportFragmentManager , roomViewModel)
        mainBinding.recycler.apply {
            adapter  = roomDataAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }

        roomViewModel.userList.observe(this) {
            roomDataAdapter.submitList(it)
        }
    }

     @OptIn(DelicateCoroutinesApi::class)
      fun addUserOnclick()
    {
        if(mainBinding.addUserDia.editFname.text.toString().isEmpty())
        {
            mainBinding.addUserDia.editFname.error = "Please fill it"
            return
        }
        else if(mainBinding.addUserDia.editLname.text.toString().isEmpty())
        {
            mainBinding.addUserDia.editLname.error = "Please fill it"
            return
        }
        else if(mainBinding.addUserDia.editAge.text.toString().isEmpty())
        {
            mainBinding.addUserDia.editAge.error = "Please fill it"
            return
        }
        else {
            val fName = mainBinding.addUserDia.editFname.text.toString()
            val lName = mainBinding.addUserDia.editLname.text.toString()
            val age =  mainBinding.addUserDia.editAge.text.toString()

            roomViewModel.insertUser(
                    User(0, fName , lName , age )
                )
               showPopUp()
            Toast.makeText(
                applicationContext,
                "User has been added to Room database",
                Toast.LENGTH_SHORT
            ).show()
            mainBinding.addUserDia.editFname.setText("")
            mainBinding.addUserDia.editLname.setText("")
            mainBinding.addUserDia.editAge.setText("")

        }

    }
    fun showPopUp()
    {
        val userAddedDialog : UserAddedDialog = UserAddedDialog()
        userAddedDialog.show(supportFragmentManager , "t")

    }
}