package com.motion.muslimcollection.ui.homefragment

import android.view.*
import androidx.activity.OnBackPressedCallback
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

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

    }
    private fun closeScreen(){
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback)

    }

    override fun setupUI() {
        super.setupUI()
        closeScreen()


    }

}


