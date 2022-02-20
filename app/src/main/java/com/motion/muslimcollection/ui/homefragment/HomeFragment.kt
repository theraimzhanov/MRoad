package com.motion.muslimcollection.ui.homefragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.view.menu.MenuBuilder
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    override fun setupObservers() {
    }

    override fun showConnectedState() {
        toolbar.inflateMenu(R.menu.menu_item)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_res -> {
                    (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_otherResourceFragment)
                    true
                }
                R.id.menu_share -> {
                   share()
                    true
                }
                R.id.menu_app -> {
                    (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_appFragment)
                    true
                }
                R.id.menu_set -> {
                    (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_settingsFragment)
                    true
                }
                R.id.menu_work -> {
                    (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_workFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun share() {

    }

    override fun saveOnBoard(b: Boolean) {
    }

    override fun setupUI() {
        super.setupUI()

        closeScreen()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)}

    override fun showBottomNavigation() {
        super.showBottomNavigation()
        requireActivity().bottomNavigationView.visibility = View.VISIBLE
    }

    private fun closeScreen() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}

