package com.motion.muslimcollection.ui.mosque.mosque_room

import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_add__room.*
import kotlinx.android.synthetic.main.fragment_madrasah.*

class AddRoomFragment : BaseFragment(R.layout.fragment_add__room) {
    override fun setupObservers() {
    }

    override fun showConnectedState() {
    }

    override fun setupUI() {
        super.setupUI()
        rm_back.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_addRoomFragment_to_roomFragment)
        }
    }


}