package com.motion.muslimcollection.ui.mechet.screenmechet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity

import kotlinx.android.synthetic.main.fragment_mechet.*
import kotlinx.android.synthetic.main.fragment_screen_mechet.*

class ScreenMechetFragment : BaseFragment(R.layout.fragment_screen_mechet) {
    override fun setupObservers() {
    }

    override fun showConnectedState() {

    }

    override fun setupUI() {
        super.setupUI()
        nextFr()
    }

    fun nextFr() {
        add_mechet_next.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_screenMechetFragment_to_addMechetFragment)
        }
    }
}