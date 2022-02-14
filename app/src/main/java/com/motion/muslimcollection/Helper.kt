package com.motion.muslimcollection

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import java.util.*

class Helper(var context: Context) {

    companion object {
        fun setLang(context: Context) {
            val sharedPreferences =
                context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val value = sharedPreferences.getString("lang", "ru")
            val locale = Locale(value)
            Locale.setDefault(locale)
            val config = context.resources.configuration
            config.setLocale(locale)
            context.createConfigurationContext(config)
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
        }
        fun changeTheme(context: Context){
            val sharedPreferences =
                context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val state = sharedPreferences.getInt("change", 1)
            if (state == 1) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else if (state == 2) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }

    }
}


