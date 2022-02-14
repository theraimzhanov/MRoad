package com.motion.muslimcollection.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.motion.muslimcollection.utils.networkConnectivityChecker.NetworkConnectivityChecker

abstract class BaseActivity(private val layout: Int) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        setupUI()
        NetworkConnectivityChecker.observe(this, liveDataObserver)
    }
    override fun onResume() {
        super.onResume()
        NetworkConnectivityChecker.checkForConnection()
    }

    private val liveDataObserver: Observer<Boolean> = Observer { isConnected ->
        if (!isConnected) {
            showDisconnectState()
        } else {
            showConnectedState()
        }
    }

    private fun showDisconnectState() {

    }

    private fun showConnectedState() {

    }

    abstract fun setupUI()

}
