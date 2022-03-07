package com.motion.muslimcollection.ui.home_fragment


import android.annotation.SuppressLint
import android.os.Handler
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.getFormattedTime
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.network.result.Status

import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_add_vacancy.*
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val viewModel: TimeViewModel by inject()
    private var passedSeconds = 0
    private var calendar = Calendar.getInstance()
    private val updateHandler = Handler()

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_item, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_set -> (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_settingsFragment2)

            R.id.menu_app -> (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_appFragment)

            R.id.menu_work -> (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_vacancyFragment)
        }
        return super.onOptionsItemSelected(item)

    }


    override fun onPause() {
        super.onPause()
        updateHandler.removeCallbacksAndMessages(null)
    }

    override fun onResume() {
        super.onResume()
        setupDateTime()
    }

    override fun setupObservers() {
        setUpTime()
    }
    override fun showConnectedState() {

    }
    @SuppressLint("SimpleDateFormat")
    private fun setUpTime() {
        val date = Date()
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val strDate = formatter.format(date)
        viewModel.getTimeItem(strDate)

        viewModel.item.observe(viewLifecycleOwner){ it ->
            when(it.status){
                Status.LOADING -> {
                }
                Status.SUCCESS -> {

                    it.data?.let {
                        tv_first_time.text =it.first_time.substring(0,5)
                         tv_second_time.text = it.second_time.substring(0,5)
                        tv_third_time.text = it.third_time.substring(0,5)
                        tv_fourth_time.text = it.fourth_time.substring(0,5)
                        tv_fifth_time.text = it.fifth_time.substring(0,5)
                        tv_sixth_time.text = it.sixth_time.substring(0,5)
                    }
                }
                Status.ERROR -> {
                    context?.showMessage(it.message)
                }
            }
        }
    }

    private fun setupDateTime() {
        calendar = Calendar.getInstance()
        passedSeconds = fetchPassedSeconds()
        updateCurrentTime()
    }
    private fun updateCurrentTime() {
        tv_current_time.text = requireContext().getFormattedTime(passedSeconds)
        updateHandler.postDelayed({
            passedSeconds++
            updateCurrentTime()
        }, ONE_SECOND)
    }

    private fun fetchPassedSeconds(): Int {
        val calendar = Calendar.getInstance()
        val isDaylightSavingActive = TimeZone.getDefault().inDaylightTime(Date())
        var offset = calendar.timeZone.rawOffset
        if (isDaylightSavingActive) {
            offset += TimeZone.getDefault().dstSavings
        }
        return ((calendar.timeInMillis + offset) / 1000).toInt()
    }


    @SuppressLint("SimpleDateFormat")
    override fun setupUI() {
        super.setupUI()
        closeScreen()
        (requireActivity() as? MainActivity)?.setSupportActionBar(home_toolbar)
    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()
    }

    private fun closeScreen() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
    companion object {
        private const val ONE_SECOND: Long = 1000L
    }

}

