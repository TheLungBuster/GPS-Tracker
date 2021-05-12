package com.enteld.gpstracker.feature.map.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.enteld.gpstracker.R
import com.enteld.gpstracker.core.BindingFragment
import com.enteld.gpstracker.databinding.FragmentMapBinding
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style

class MapFragment : BindingFragment<FragmentMapBinding>() {

    override fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMapBinding.inflate(inflater, container, false)

    override fun otherSetups(savedInstanceState: Bundle?) {
        initMap(savedInstanceState)
    }

    private fun initMap(savedInstanceState: Bundle?) {
        with(binding) {
            mapView.onCreate(savedInstanceState)
            mapView.getMapAsync {
                it.setStyle(Style.MAPBOX_STREETS)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()
    }
}