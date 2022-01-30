package com.motion.muslimcollection.ui.mechet.screenmechet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

class ScreenMechetFragment : BaseFragment(R.layout.fragment_screen_mechet) {
    override fun setupObservers() {
    }

    override fun showConnectedState() {

    }

    override fun setupUI() {
        super.setupUI()
    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()
        requireActivity().toolbar.visibility = View.GONE

    }


}