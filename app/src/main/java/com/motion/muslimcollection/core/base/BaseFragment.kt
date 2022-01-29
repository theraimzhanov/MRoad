package com.motion.muslimcollection.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.motion.muslimcollection.utils.networkConnectivityChecker.NetworkConnectivityChecker

abstract class BaseFragment(private val layout: Int) :
    Fragment() {

    private val liveDataObserver: Observer<Boolean> = Observer { isConnected ->
        if (!isConnected) {
            showDisconnectState()
        } else {
            showConnectedState()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        showBottomNavigation()
        return inflater.inflate(layout, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
        NetworkConnectivityChecker.observe(viewLifecycleOwner, liveDataObserver)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        set()

    }


    open fun set() {}

    open fun showBottomNavigation() {
    }

    abstract fun setupObservers()

    open fun setupUI() {}

    abstract fun showConnectedState()

    open fun showDisconnectState() {}
}




