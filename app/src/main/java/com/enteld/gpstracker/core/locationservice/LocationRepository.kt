package com.enteld.gpstracker.core.locationservice

import android.location.Location
import android.util.Log
import com.enteld.gpstracker.domain.entity.Coordinates
import com.enteld.gpstracker.domain.usecase.SendLocationUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class LocationRepository(
    private val locationManager: LocationManager,
    private val scope: CoroutineScope,
    private val sendLocationUseCase: SendLocationUseCase
) {

    fun sendCoordinates() {
        locationManager.getUpdatedLocation { location ->  onLocationReceived(location)}
    }

    private fun onLocationReceived(location: Location?) = scope.launch {
        Log.d("onLocationReceived", "wewewe")
        location?.let {
            Log.d("onLocationReceived In", "wewewe")
            sendLocationUseCase(it.toCoordinates())
        }
    }
}

fun Location.toCoordinates() =
    Coordinates(
        long = this.longitude,
        lat = this.latitude
    )