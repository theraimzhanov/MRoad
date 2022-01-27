package com.motion.muslimcollection.ui.mechet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*


class MechetFragment : BaseFragment(R.layout.fragment_mechet) {
    override fun setupObservers() {
    }

    override fun showConnectedState() {
    }

    override fun setupUI() {
        super.setupUI()

    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()
        requireActivity().toolbar_text.text = resources.getString(R.string.ss)

    }

}
