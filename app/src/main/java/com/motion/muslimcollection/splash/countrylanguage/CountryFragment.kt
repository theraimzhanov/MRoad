package com.motion.muslimcollection.splash.countrylanguage

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.addfastfood.*
import kotlinx.android.synthetic.main.fragment_country.*

class CountryFragment : BaseFragment(R.layout.fragment_country) {
    private lateinit var sharedPreferences: SharedPreferences

    override fun showBottomNavigation() {
        super.showBottomNavigation()
        requireActivity().bottomNavigationView.visibility = View.GONE

    }
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }*/

    override fun setupObservers() {

    }
    override fun setupUI() {
        super.setupUI()
        sharedPreferences =
            requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        navigate()
        setValue()
        installRadioButton()
    }

    override fun showConnectedState() {

    }

    override fun saveOnBoard(b: Boolean) {
        TODO("Not yet implemented")
    }

    private fun installRadioButton() {
        val state = sharedPreferences?.getInt("position", 0)
        //requireActivity().toolbar_text.text = sharedPreferences.getString("country", "Кыргызстан")
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
        //requireActivity().toolbar_text.text = value
        sharedPreferences!!.edit().apply {
            putInt("position", position)
            putString("country", value)
        }.apply()
    }
    private fun navigate() {
        val oneTime = sharedPreferences?.getBoolean("oneTime", false)
        requireActivity().toolbar_back.setOnClickListener {
            when (oneTime) {
                true -> (activity as MainActivity).navController.navigate(R.id.action_countryFragment_to_homeFragment)

                false ->
                    (activity as MainActivity).navController.navigate(R.id.action_countryFragment_to_country_Language_Fragment)
            }
        }
    }

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false)
    }*/

}