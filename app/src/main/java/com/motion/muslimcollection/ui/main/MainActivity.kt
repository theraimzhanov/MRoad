package com.motion.muslimcollection.ui.main

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseActivity

class MainActivity : BaseActivity(R.layout.activity_main) {

    lateinit var navController: NavController
    override fun setupUI() {
        navigat()
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_view)
       val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
       val navController = navHostFragment?.findNavController()
       if (navController != null) { bottomNavigationView.setupWithNavController(navController)
        }
    }
    private fun navigat() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }
}





