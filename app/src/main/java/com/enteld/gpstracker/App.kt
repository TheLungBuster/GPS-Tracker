package com.enteld.gpstracker

import android.app.Application
import com.enteld.gpstracker.core.di.GpsWorkerModule
import com.enteld.gpstracker.core.locationservice.GpsWorker
import com.enteld.gpstracker.di.AppModule
import com.enteld.gpstracker.domain.di.DomainModule
import com.enteld.gpstracker.feature.connectionmenu.di.ConnectionMenuModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(AppModule)
            modules(ConnectionMenuModule)
            modules(DomainModule)
            modules(GpsWorkerModule)
            GpsWorker.schedule(applicationContext)
        }
    }
}