package com.motion.muslimcollection.ui.menu

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {
    private lateinit var sharedPreferences: SharedPreferences

    override fun setupObservers() {

    }
    override fun showConnectedState() {
        city_picker_sett.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_settingsFragment2_to_cityPickerFragment)
        }
    }
    override fun setupUI() {
        super.setupUI()
        sharedPreferences = requireActivity().getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        navigate()
        installRadioButton()
        setValue()
    }
    private fun installRadioButton() {
        val state = sharedPreferences.getInt("checked", 2)
        if (state == 1) {
            btn_ky.isChecked = true
        } else if (state == 2) {
            btn_ru.isChecked = true
        }
    }
    private fun setValue() {
        group_lang.setOnCheckedChangeListener { _, i ->
            if (i == R.id.btn_ky) {
                saveLang("ky")
                saveChecked(2)
                requireActivity().toolbar_text.text = btn_ky.text
            } else if (i == R.id.btn_ru) {
                saveLang("ru")
                saveChecked(1)
                requireActivity().toolbar_text.text = btn_ru.text
            }
        }
    }
    @SuppressLint("CommitPrefEdits")
    private fun saveLang(value: String) {
        sharedPreferences.edit().apply {
            putString("lang", value)
        }.apply()
        com.motion.muslimcollection.helper.Helper.setLang(requireContext())
    }
    @SuppressLint("CommitPrefEdits")
    private fun saveChecked(value: Int) {
        sharedPreferences.edit().apply {
            putInt("checked", value)
        }.apply()
    }
    private fun navigate() {
        val oneTime = sharedPreferences.getBoolean("oneTime",false)
        requireActivity().exitSetting.setOnClickListener {
            when(oneTime){
                true -> (activity as MainActivity).navController.navigate(R.id.action_settingsFragment2_to_homeFragment)
                false-> (activity as MainActivity).navController.navigate(R.id.action_settingsFragment2_to_homeFragment)
            }
        }
        btnSite.setOnClickListener {
            val url = "https://www.motion-webllc.com/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        btnInsta.setOnClickListener {
            val uri = Uri.parse("http://instagram.com/_u/motion_web")
            val likeIng = Intent(Intent.ACTION_VIEW, uri)
            likeIng.setPackage("com.instagram.android")
            try {
                startActivity(likeIng)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/motion_web")
                    )
                )
            }
        }
        btnFaceBook.setOnClickListener {
            val url = "https://m.facebook.com/Web-Motion-1926623227573688/photos/?ref=page_internal"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        btnVC.setOnClickListener {
            val url = "https://vk.com/wall-17872403_364"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        btnOneClass.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        "https://api.whatsapp.com/send?phone=+996707434390 Number&text=You are handsome"
                    )
                )
            )
        }
    }

}