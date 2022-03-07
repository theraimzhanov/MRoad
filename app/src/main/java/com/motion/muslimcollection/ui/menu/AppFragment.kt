package com.motion.muslimcollection.ui.menu

import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_app.*

class AppFragment : BaseFragment(R.layout.fragment_app) {

    override fun setupObservers() {

    }
    override fun showConnectedState() {
        exit_city.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_appFragment_to_homeFragment)
        }
    }
}