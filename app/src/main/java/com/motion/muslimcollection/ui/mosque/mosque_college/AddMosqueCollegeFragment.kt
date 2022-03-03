package com.motion.muslimcollection.ui.mosque.mosque_college
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_add_mechet.*
import kotlinx.android.synthetic.main.fragment_add_mosque__college.*

class AddMosqueCollegeFragment : BaseFragment(R.layout.fragment_add_mosque__college) {
    override fun setupObservers() {

    }

    override fun showConnectedState() {

    }


    override fun setupUI() {
        super.setupUI()
        cl_back.setOnClickListener {
            activity?.onBackPressed()
        }
    }



}