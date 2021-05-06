package com.enteld.gpstracker.feature.connectionmenu.ui.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.enteld.gpstracker.databinding.ConnectionMenuPageBinding
import com.enteld.gpstracker.feature.connectionmenu.ui.recyclerview.ConnectionMenuRVAdapter

class ConnectionMenuViewHolder(
    binding: ConnectionMenuPageBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(
            parent: ViewGroup,
            lifecycleOwner: LifecycleOwner,
            pageType: PageType
        ): ConnectionMenuViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ConnectionMenuPageBinding.inflate(layoutInflater, parent, false)
            val adapter = ConnectionMenuRVAdapter(lifecycleOwner, pageType)
            return ConnectionMenuViewHolder(binding)
        }
    }
}