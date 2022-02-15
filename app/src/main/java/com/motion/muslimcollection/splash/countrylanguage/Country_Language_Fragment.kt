package com.motion.muslimcollection.splash.countrylanguage

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_country__language_.*

class Country_Language_Fragment : BaseFragment(R.layout.fragment_country__language_) {
    override fun setupObservers() {

    }

    override fun showConnectedState() {

    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()

    }
    override fun setupUI() {
        super.setupUI()
        navigate()

    }
    private fun navigate() {
        cons_country.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_country_Language_Fragment_to_countryFragment)
        }
        cons_language.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_country_Language_Fragment_to_languageFragment)
        }
        next.setOnClickListener {
            saveOnBoard(true)
            (activity as MainActivity).navController.navigate(R.id.action_country_Language_Fragment_to_homeFragment)
        }
    }
    @SuppressLint("CommitPrefEdits")
    override  fun saveOnBoard(click: Boolean) {
        val sharedPreferences =
            requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().apply {
            putBoolean("click", click)
        }.apply()
    }
}