package com.motion.muslimcollection.ui.lessons


import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.mechet.screenmechet.addmechet.AddMechetFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_lessons.*


class LessonsFragment : BaseFragment(R.layout.fragment_lessons) {
    override fun setupObservers() {
    }

    override fun showConnectedState() {
    }

    override fun setupUI() {
        super.setupUI()
        navigation()

    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()
      //  requireActivity().toolbar_text.text = resources.getString(R.string.lessons)
    }
    private fun navigation(){
        button.setOnClickListener{
           requireActivity().supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment,AddMechetFragment()).commit()
        }
    }

}