package com.example.kotlin_roomdb.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_roomdb.database.LiveUser
import com.example.kotlin_roomdb.databinding.UserItemBinding
import kotlin.math.absoluteValue


class RoomDataAdapter(
    private val context: Context,
    private val supportFragmentManager: FragmentManager,
) : ListAdapter<LiveUser, RoomDataAdapter.ViewHolder>(Diffutil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, context, supportFragmentManager)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: UserItemBinding,
        val context: Context,
        private val supportFragmentManager: FragmentManager
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: LiveUser) {
            binding.liveUser = user
            binding.updateDiaLogBox = UserUpdateDialogBox(context, user, supportFragmentManager)

        }
    }
}

class Diffutil : DiffUtil.ItemCallback<LiveUser>() {
    override fun areItemsTheSame(oldItemPosition: LiveUser, newItemPosition: LiveUser): Boolean {
        return oldItemPosition.id.absoluteValue == newItemPosition.id.absoluteValue
    }

    override fun areContentsTheSame(oldItemPosition: LiveUser, newItemPosition: LiveUser): Boolean {
        return oldItemPosition == newItemPosition
    }

}
