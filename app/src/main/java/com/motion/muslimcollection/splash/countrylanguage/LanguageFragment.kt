package com.motion.muslimcollection.splash.countrylanguage

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.motion.muslimcollection.Helper
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_language.*

class LanguageFragment : BaseFragment(R.layout.fragment_language) {
    private lateinit var sharedPreferences: SharedPreferences

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }*/

    override fun setupObservers() {

    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()
        requireActivity().bottomNavigationView.visibility = View.GONE
        //requireActivity().toolbar.visibility = View.VISIBLE

    }
    override fun setupUI() {
        super.setupUI()
        sharedPreferences = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        navigate()
        installRadioButton()
        setValue()

    }

    override fun showConnectedState() {

    }
    private fun installRadioButton() {
        val state = sharedPreferences.getInt("checked", 3)
        if (state == 1) {
            btn_ky.isChecked = true
        } else if (state == 2) {
            btn_ru.isChecked = true
        }
    }
    private fun setValue() {
        group_lang.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.btn_ky) {
                saveLang("ky")
                saveChecked(1)
                requireActivity().toolbar_text.text = btn_ky.text
            } else if (i == R.id.btn_ru) {
                saveLang("ru")
                saveChecked(2)
                requireActivity().toolbar_text.text = btn_ru.text
            }
        }
    }
    @SuppressLint("CommitPrefEdits")
    private fun saveLang(value: String) {

        sharedPreferences.edit().apply {
            putString("lang", value)
        }.apply()
        Helper.setLang(requireContext())
    }
    @SuppressLint("CommitPrefEdits")
    private fun saveChecked(value: Int) {
        sharedPreferences.edit().apply {
            putInt("checked", value)
        }.apply()
    }
    private fun navigate() {
        val oneTime = sharedPreferences.getBoolean("oneTime",false)
    }

    override fun saveOnBoard(b: Boolean) {

    }

  /*  override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_language, container, false)
    }*/

}