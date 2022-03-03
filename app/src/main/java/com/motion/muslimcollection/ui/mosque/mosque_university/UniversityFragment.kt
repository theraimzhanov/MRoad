package com.motion.muslimcollection.ui.mosque.mosque_university


import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_madrasah.*
import kotlinx.android.synthetic.main.fragment_mosque_university.*
import kotlinx.android.synthetic.main.fragment_vacancy.*

class UniversityFragment : BaseFragment(R.layout.fragment_mosque_university) {
    override fun setupObservers() {

    }

    override fun showConnectedState() {

    }

    override fun setupUI() {
        super.setupUI()
        back()
        btn_add_un.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_universityFragment_to_addUniversityFragment)
        }
    }
    private fun back() {

    }

}