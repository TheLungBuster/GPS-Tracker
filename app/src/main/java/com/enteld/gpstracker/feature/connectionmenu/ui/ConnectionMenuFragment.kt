package com.enteld.gpstracker.feature.connectionmenu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.enteld.gpstracker.core.BindingFragment
import com.enteld.gpstracker.databinding.FragmentConnectionMenuBinding

class ConnectionMenuFragment: BindingFragment<FragmentConnectionMenuBinding>() {

    override fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentConnectionMenuBinding.inflate(inflater, container, false)

    override fun otherSetups() {}
}