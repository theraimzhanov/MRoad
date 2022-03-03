package com.motion.muslimcollection.ui.main

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.widget.Toolbar
import androidx.activity.result.ActivityResultLauncher
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.fragment_home.*

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





