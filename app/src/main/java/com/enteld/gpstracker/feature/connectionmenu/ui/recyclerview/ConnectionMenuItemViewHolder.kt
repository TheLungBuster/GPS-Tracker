package com.enteld.gpstracker.feature.connectionmenu.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.enteld.gpstracker.databinding.ConnectionMenuItemBinding
import com.enteld.gpstracker.domain.entity.UserCard
import com.enteld.gpstracker.feature.connectionmenu.presentation.ConnectionMenuViewModel
import com.enteld.gpstracker.feature.connectionmenu.ui.viewpager.PageType
import kotlinx.coroutines.flow.onEach

class ConnectionMenuItemViewHolder(
    private val binding: ConnectionMenuItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        data: UserCard,
        pageType: PageType
    ) {
        with(binding) {
            userName.text = data.name
            when (pageType) {
                PageType.FollowersPage  -> {
                    hasPermissionSwitch.isChecked = data.hasPermission
                    hasPermissionSwitch.isVisible = true
                    isShownSwitch.isVisible = false
                }
                PageType.FollowedPage   -> {
                    isShownSwitch.isChecked = data.isShown
                    isShownSwitch.isVisible = true
                    hasPermissionSwitch.isVisible = false
                }
            }
        }
    }

    companion object {
        fun from(parent: ViewGroup): ConnectionMenuItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ConnectionMenuItemBinding.inflate(layoutInflater, parent, false)
            return ConnectionMenuItemViewHolder(binding)
        }
    }
}