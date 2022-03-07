package com.motion.muslimcollection.ui.menu

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_city_picker.*

class CityPickerFragment : BaseFragment(R.layout.fragment_city_picker) {

    private lateinit var sharedPreferences: SharedPreferences

    override fun setupObservers() {

    }
    override fun showConnectedState() {

    }
    override fun setupUI() {
        super.setupUI()
        sharedPreferences = requireActivity().getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        navigate()
        setValue()
        installRadioButton()
    }
    private fun installRadioButton() {
        val state = sharedPreferences.getInt("position", 0)
        requireActivity().toolbar_text.text = sharedPreferences.getString("country", "Кыргызстан")
        when (state) {
            1 -> country_1.isChecked = true
            2 -> country_2.isChecked = true
            3 -> country_3.isChecked = true
            4 -> country_4.isChecked = true
            5 -> country_5.isChecked = true
            6 -> country_6.isChecked = true
            7 -> country_7.isChecked = true
            8 -> country_8.isChecked = true
            9 -> country_9.isChecked = true
        }
    }
    private fun setValue() {
        group_country.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.country_1 -> saveLocale(country_1.text.toString(), 1)
                R.id.country_2 -> saveLocale(country_2.text.toString(), 2)
                R.id.country_3 -> saveLocale(country_3.text.toString(), 3)
                R.id.country_4 -> saveLocale(country_4.text.toString(), 4)
                R.id.country_5 -> saveLocale(country_5.text.toString(), 5)
                R.id.country_6 -> saveLocale(country_6.text.toString(), 6)
                R.id.country_7 -> saveLocale(country_7.text.toString(), 7)
                R.id.country_8 -> saveLocale(country_8.text.toString(), 8)
                R.id.country_9 -> saveLocale(country_9.text.toString(), 9)
            }
        }
    }
    @SuppressLint("CommitPrefEdits")
    private fun saveLocale(value: String, position: Int) {
        requireActivity().toolbar_text.text = value
        sharedPreferences.edit().apply {
            putInt("position", position)
            putString("country", value)
        }.apply()
    }
    private fun navigate() {
        val oneTime = sharedPreferences.getBoolean("oneTime", false)
        requireActivity().exit_city.setOnClickListener {
            when (oneTime) {
                true -> (activity as MainActivity).navController.navigate(R.id.action_cityPickerFragment_to_settingsFragment2)

                false ->
                    (activity as MainActivity).navController.navigate(R.id.action_cityPickerFragment_to_settingsFragment2)
            }
        }
    }
}