package com.enteld.gpstracker.feature.connectionmenu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.enteld.gpstracker.R
import com.enteld.gpstracker.core.BindingFragment
import com.enteld.gpstracker.databinding.FragmentConnectionMenuBinding
import com.enteld.gpstracker.feature.connectionmenu.presentation.ConnectionMenuViewModel
import com.enteld.gpstracker.feature.connectionmenu.ui.viewpager.ConnectionMenuVPAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConnectionMenuFragment: BindingFragment<FragmentConnectionMenuBinding>() {

    private val viewModel by viewModel<ConnectionMenuViewModel>()

    override fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentConnectionMenuBinding.inflate(inflater, container, false)

    override fun otherSetups(savedInstanceState: Bundle?) {
        initViewPager()
    }

    private fun initViewPager() {
        binding.connectionMenuViewPager.adapter = ConnectionMenuVPAdapter(viewLifecycleOwner, viewModel)
        TabLayoutMediator(
            binding.connectionMenuTabLayout,
            binding.connectionMenuViewPager
        ) { tab, position ->
            binding.connectionMenuViewPager.setCurrentItem(tab.position, true)
                tab.text = when(position) {
                    0       ->  getString(R.string.followers_user_title)
                    else    ->  getString(R.string.followed_user_title)
                }
        }.attach()
    }
}