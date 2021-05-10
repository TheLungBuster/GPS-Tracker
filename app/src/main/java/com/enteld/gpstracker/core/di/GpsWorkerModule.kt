package com.enteld.gpstracker.core.di

import com.enteld.gpstracker.core.locationservice.LocationManager
import com.enteld.gpstracker.core.locationservice.LocationRepository
import get
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val GpsWorkerModule = module {

    single { LocationManager(androidContext()) }
    single { LocationRepository(
        locationManager = get(),
        scope = get(),
        sendLocationUseCase = get()
    ) }
}