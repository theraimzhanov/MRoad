package com.motion.muslimcollection.splash

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseActivity
import com.motion.muslimcollection.ui.main.MainActivity

@Suppress("DEPRECATION")
class SplashMainActivity : BaseActivity(R.layout.activity_splash_main) {
    override fun setupUI() {

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val backgroundImage: ImageView = findViewById(R.id.logo_icon)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.anim)
        backgroundImage.startAnimation(slideAnimation)
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

}


