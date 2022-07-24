package com.example.kotlin_roomdb.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_roomdb.ui.DialogBox
import com.example.kotlin_roomdb.repository.UserRepository
import com.example.kotlin_roomdb.database.User
import com.example.kotlin_roomdb.databinding.UserItemBinding
import com.example.kotlin_roomdb.viewmodel.RoomViewModel


class RoomDataAdapter(
    private val context: Context,
    private val supportFragmentManager: FragmentManager
) : ListAdapter<User, RoomDataAdapter.ViewHolder>(Diffutil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        val roomviewmodel = RoomViewModel(UserRepository(context))
        val user: User = getItem(position)
        holder.binding.deleteUser.setOnClickListener {
            roomviewmodel.deleteUser(user)
        }
        holder.binding.editUser.setOnClickListener {
            val dialogBox = DialogBox(context, user)
            dialogBox.show(supportFragmentManager, "t")
        }
    }

    class ViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.firstnameText.text = "Fname: " + user.firstName
            binding.lastnameText.text = "Lname: " + user.lastName
            binding.ageText.text = "Age: " + user.age
            binding.idText.text = "Id: " + user.Id.toString()
        }
    }
}

class Diffutil : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItemPosition: User, newItemPosition: User): Boolean {
        return oldItemPosition.Id == newItemPosition.Id
    }

    override fun areContentsTheSame(oldItemPosition: User, newItemPosition: User): Boolean {
        return oldItemPosition.Id == newItemPosition.Id
    }

}
