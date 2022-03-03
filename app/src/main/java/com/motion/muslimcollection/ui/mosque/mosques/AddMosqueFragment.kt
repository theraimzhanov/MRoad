package com.motion.muslimcollection.ui.mosque.mosques

import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_add_mechet.*

class AddMosqueFragment:BaseFragment(R.layout.fragment_add_mechet) {

    override fun setupObservers() {
    }

    override fun showConnectedState() {

    }

    override fun setupUI() {
        super.setupUI()
        ms_back.setOnClickListener {
            activity?.onBackPressed()
        }
    }


}