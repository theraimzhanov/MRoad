package com.motion.muslimcollection.ui.mosque.mosques

import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_mosques.*



class MosquesFragment : BaseFragment(R.layout.fragment_mosques) {
    override fun setupObservers() {
    }

    override fun showConnectedState() {

    }
    override fun setupUI() {
        super.setupUI()
        next()
    }

    fun next() {
        add_mechet_next.setOnClickListener {
          //  (activity as MainActivity).navController.navigate(R.id.action_screenMechetFragment_to_addMechetFragment)
        }
    }
}