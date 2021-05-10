package com.enteld.gpstracker.feature.connectionmenu.ui.viewpager

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.enteld.gpstracker.feature.connectionmenu.presentation.ConnectionMenuViewModel

class ConnectionMenuVPAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: ConnectionMenuViewModel
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val FOLLOWERS_PAGE = 0
        const val FOLLOWED_PAGE = 1
        const val PAGES_COUNT = 2
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder =
        when(viewType) {
            FOLLOWERS_PAGE  -> {
                ConnectionMenuViewHolder.from(
                    parent = parent,
                    lifecycleOwner = lifecycleOwner,
                    viewModel = viewModel,
                    pageType = PageType.FollowersPage
                )
            }

            FOLLOWED_PAGE   -> {
                ConnectionMenuViewHolder.from(
                    parent = parent,
                    lifecycleOwner = lifecycleOwner,
                    viewModel = viewModel,
                    pageType = PageType.FollowedPage
                )
            }

            else            -> throw IllegalArgumentException()
        }

    override fun getItemViewType(position: Int): Int = position

    override fun getItemCount(): Int = PAGES_COUNT

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {}
}