package com.enteld.gpstracker.feature.map.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.enteld.gpstracker.core.BindingFragment
import com.enteld.gpstracker.databinding.FragmentMapBinding

class MapFragment: BindingFragment<FragmentMapBinding>() {

    override fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMapBinding.inflate(inflater, container, false)

    override fun otherSetups() {}
}