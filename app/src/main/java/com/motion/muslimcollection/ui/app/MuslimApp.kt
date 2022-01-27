package com.motion.muslimcollection.ui.app

import android.app.Application
import com.motion.muslimcollection.di.koinModules
import com.motion.muslimcollection.utils.networkConnectivityChecker.NetworkConnectivityChecker
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MuslimApp : Application() {
    override fun onCreate() {
        super.onCreate()
        NetworkConnectivityChecker.init(this.applicationContext)
        startKoin {
            androidContext(this@MuslimApp)
            modules(koinModules)
        }

    }
}