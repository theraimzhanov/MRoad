package com.motion.muslimcollection.ui.mosque.mosque_madrasah

import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_add_madrasah.*
import kotlinx.android.synthetic.main.fragment_madrasah.*


class AddMadrasahFragment : BaseFragment(R.layout.fragment_add_madrasah) {
    override fun setupObservers() {

    }
    override fun showConnectedState() {

    }


    override fun setupUI() {
        super.setupUI()
        md_back.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_addMadrasahFragment_to_madrasahFragment)
        }
    }


}