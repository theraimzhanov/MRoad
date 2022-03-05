package com.motion.muslimcollection.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseActivity
import com.motion.muslimcollection.ui.main.MainActivity

class SplashMainActivity : BaseActivity(R.layout.activity_splash_main) {

    override fun setupUI() {
        Handler(Looper.myLooper()!!).postDelayed({
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 2000)
    }

}