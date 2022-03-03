package com.motion.muslimcollection.ui.mosque.mosque_library

import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_add_library.*
import kotlinx.android.synthetic.main.fragment_library.*

class AddLibraryFragment : BaseFragment(R.layout.fragment_add_library) {
    override fun setupObservers() {

    }

    override fun showConnectedState() {

    }


    override fun setupUI() {
        super.setupUI()
        lb_back.setOnClickListener {
            activity?.onBackPressed()
        }
    }


}