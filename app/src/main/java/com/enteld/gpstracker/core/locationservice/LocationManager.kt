package com.enteld.gpstracker.core.locationservice

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices

class LocationManager(private val context: Context) {

    fun getUpdatedLocation(block: (Location?) -> Unit) {

        val permission = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)

        if (permission == PackageManager.PERMISSION_GRANTED) {
            Log.d("onLocationReceived", "wewewe")
            LocationServices.getFusedLocationProviderClient(context).lastLocation.addOnSuccessListener { location ->
                block.invoke(location)
            }
        } else {
            block.invoke(null)
        }
    }
}