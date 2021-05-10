package com.enteld.gpstracker.core.locationservice

import android.content.Context
import android.util.Log
import androidx.work.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.concurrent.TimeUnit

class GpsWorker(
    appContext: Context,
    params: WorkerParameters,
) : CoroutineWorker(appContext, params), KoinComponent {

    private val locationRepository: LocationRepository by inject()

    companion object {
        private const val TAG = "TrackingLocationWorker"
        private const val DEFAULT_MIN_INTERVAL = 15L

        fun schedule(context: Context) {
            val worker = PeriodicWorkRequestBuilder<GpsWorker>(DEFAULT_MIN_INTERVAL, TimeUnit.MINUTES)
                .addTag(TAG).build()
            WorkManager.getInstance(context)
                .enqueueUniquePeriodicWork(TAG, ExistingPeriodicWorkPolicy.REPLACE, worker)
        }
    }

    override suspend fun doWork(): Result =
        withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "wewewe")
                locationRepository.sendCoordinates()
                Result.success()
            } catch (e: Exception) {
                Log.d(TAG, "Exception getting location -->  ${e.message}")
                Result.failure()
            }
        }
}