package com.motion.muslimcollection.ui.menu

import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_add_vacancy.*
import kotlinx.android.synthetic.main.fragment_work.*


class WorkFragment : BaseFragment(R.layout.fragment_work) {
    override fun setupObservers() {

    }

    override fun showConnectedState() {
        goToVacancyFragment.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_workFragment_to_addVacancyFragment)
        }
    }

    override fun saveOnBoard(b: Boolean) {

    }


}