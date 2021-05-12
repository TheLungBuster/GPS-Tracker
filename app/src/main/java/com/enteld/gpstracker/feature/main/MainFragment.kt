package com.enteld.gpstracker.feature.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.enteld.gpstracker.R
import com.enteld.gpstracker.core.BindingFragment
import com.enteld.gpstracker.core.KeepStateNavigator
import com.enteld.gpstracker.core.setupWithKeepStateNavController
import com.enteld.gpstracker.databinding.FragmentMainBinding
import com.mapbox.mapboxsdk.Mapbox

class MainFragment : BindingFragment<FragmentMainBinding>() {

    private var navigationInit = false
    private lateinit var navController: NavController
    private lateinit var navigator: KeepStateNavigator


    override fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigation()
    }

    private fun initNavigation() {
        if (!navigationInit) {
            val navHostFragment = childFragmentManager.findFragmentById(R.id.host_main)
            navigator = KeepStateNavigator(
                requireContext(),
                navHostFragment?.childFragmentManager ?: childFragmentManager,
                R.id.host_main
            )
            navController = Navigation.findNavController(requireActivity(), R.id.host_main)
            navController.navigatorProvider.addNavigator(navigator)
            navController.setGraph(R.navigation.navigation_main)
            navigationInit = true
        }
        binding.bottomNavigation.setupWithKeepStateNavController(navController, navigator)
    }

    override fun otherSetups(savedInstanceState: Bundle?) {
        context?.let { context ->
            Mapbox.getInstance(context, getString(R.string.mapbox_access_token))
        }
    }
}