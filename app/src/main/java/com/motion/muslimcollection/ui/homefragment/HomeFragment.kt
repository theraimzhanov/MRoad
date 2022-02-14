package com.motion.muslimcollection.ui.homefragment

import android.view.*
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment(R.layout.fragment_home) {

    override fun setupObservers() {
        setHasOptionsMenu(true)
    }
    override fun showConnectedState() {
    }

    override fun showBottomNavigation() {
        super.showBottomNavigation()
        requireActivity().bottomNavigationView.visibility = View.VISIBLE
    }

    override fun saveOnBoard(b: Boolean) {
        TODO("Not yet implemented")
    }

    override fun setupUI() {
        super.setupUI()
        nextMenuItem()

    }


    private fun nextMenuItem(){
        btn_menu.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_menuFragment)
        }

    }

}


