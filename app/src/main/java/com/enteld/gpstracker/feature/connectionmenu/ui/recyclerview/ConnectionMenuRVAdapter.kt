package com.enteld.gpstracker.feature.connectionmenu.ui.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.enteld.gpstracker.domain.entity.UserCard
import com.enteld.gpstracker.feature.connectionmenu.ui.viewpager.PageType

class ConnectionMenuRVAdapter(
    private val pageType: PageType
): ListAdapter<UserCard, ConnectionMenuItemViewHolder>(ConnectionMenuDiffUtilCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ConnectionMenuItemViewHolder = ConnectionMenuItemViewHolder.from(parent)

    override fun onBindViewHolder(holder: ConnectionMenuItemViewHolder, position: Int) =
        holder.bind(getItem(position), pageType)
}

class ConnectionMenuDiffUtilCallback: DiffUtil.ItemCallback<UserCard>() {
    override fun areItemsTheSame(oldItem: UserCard, newItem: UserCard) = oldItem == newItem

    override fun areContentsTheSame(oldItem: UserCard, newItem: UserCard) = oldItem == newItem
}