package com.enteld.gpstracker.feature.connectionmenu.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enteld.gpstracker.databinding.ConnectionMenuItemBinding
import com.enteld.gpstracker.domain.entity.UserCard

class ConnectionMenuItemViewHolder(
    binding: ConnectionMenuItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: UserCard) {

    }

    companion object {
        fun from(parent: ViewGroup): ConnectionMenuItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ConnectionMenuItemBinding.inflate(layoutInflater, parent, false)
            return ConnectionMenuItemViewHolder(binding)
        }
    }
}