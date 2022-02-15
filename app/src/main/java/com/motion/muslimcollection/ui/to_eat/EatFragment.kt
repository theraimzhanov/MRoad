package com.motion.muslimcollection.ui.to_eat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

class EatFragment : BaseFragment(R.layout.fragment_to_eat) {
    override fun setupObservers() {
    }

    override fun showConnectedState() {
    }

    override fun saveOnBoard(b: Boolean) {

    }
    private fun closeScreen(){
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                (activity as MainActivity).navController.navigate(R.id.action_eatFragment_to_homeFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback)
//closeScreen()//setupUI()
    }

    override fun setupUI() {
        super.setupUI()
        closeScreen()
    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()


    }


}