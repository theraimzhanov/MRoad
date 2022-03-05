package com.motion.muslimcollection.ui.home_fragment

import android.view.*
import androidx.activity.OnBackPressedCallback
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_item, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_set -> (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_settingsFragment2)

            R.id.menu_app -> (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_appFragment)

            R.id.menu_work -> (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_vacancyFragment)
        }
        return super.onOptionsItemSelected(item)

    }

    override fun setupObservers() {
    }

    override fun showConnectedState() {
    }

    override fun setupUI() {
        super.setupUI()
        closeScreen()
        (requireActivity() as? MainActivity)?.setSupportActionBar(home_toolbar)
    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()

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

