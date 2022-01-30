package com.motion.muslimcollection.ui.mechet.prayerrooms

import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*


class Prayer_RoomsFragment : BaseFragment(R.layout.fragment_prayer_rooms) {
        override fun setupObservers() {

        }

        override fun showConnectedState() {

        }

        override fun setupUI() {
                super.setupUI()
        }
    override fun showBottomNavigation() {
        super.showBottomNavigation()
        requireActivity().toolbar_text.text = resources.getString(R.string.molelnye_comnata)
    }


}