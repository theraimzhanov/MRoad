package com.motion.muslimcollection.splash

import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import android.view.View
import com.motion.muslimcollection.Helper
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : BaseFragment(R.layout.fragment_splash) {
    private lateinit var sharedPreferences: SharedPreferences
    override fun setupObservers() {
    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()
    }
    override fun setupUI() {
        sharedPreferences =
            requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val click = sharedPreferences.getBoolean("click", false)
        Helper.setLang(requireContext())
        Helper.changeTheme(requireContext())
        Handler().postDelayed({
            when (click) {
                true -> (activity as MainActivity).navController.navigate(R.id.action_splashFragment_to_homeFragment)
                false -> (activity as MainActivity).navController.navigate(R.id.action_splashFragment_to_country_Language_Fragment)
            }

        }, 2000)


        }, 1500)

    }
    override fun showConnectedState() {
    }
    override fun saveOnBoard(b: Boolean) {
    }


}