package com.enteld.gpstracker.feature.connectionmenu.ui.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.RecyclerView
import com.enteld.gpstracker.databinding.ConnectionMenuPageBinding
import com.enteld.gpstracker.feature.connectionmenu.presentation.ConnectionMenuViewModel
import com.enteld.gpstracker.feature.connectionmenu.ui.recyclerview.ConnectionMenuRVAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.scope.currentScope

class ConnectionMenuViewHolder(
    binding: ConnectionMenuPageBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(
            lifecycleOwner: LifecycleOwner,
            viewModel: ConnectionMenuViewModel,
            parent: ViewGroup,
            pageType: PageType
        ): ConnectionMenuViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ConnectionMenuPageBinding.inflate(layoutInflater, parent, false)
            val adapter = ConnectionMenuRVAdapter(pageType)
            when(pageType) {
                PageType.FollowersPage  -> {
                    viewModel.followersFlow.onEach {
                        adapter.submitList(it)
                    }.launchIn(lifecycleOwner.lifecycle.coroutineScope)
                }

                PageType.FollowedPage   -> {
                    viewModel.followedFlow.onEach {
                        adapter.submitList(it)
                    }.launchIn(lifecycleOwner.lifecycle.coroutineScope)
                }
            }
            binding.connectionMenuRecyclerView.adapter = adapter
            return ConnectionMenuViewHolder(binding)
        }
    }
}