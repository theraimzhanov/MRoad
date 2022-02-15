package com.motion.muslimcollection.ui.lessons


import androidx.activity.OnBackPressedCallback
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

    override fun saveOnBoard(b: Boolean) {

    }
    private fun closeScreen(){
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                (activity as MainActivity).navController.navigate(R.id.action_lessonsFragment_to_homeFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback)
//closeScreen()//setupUI()
    }

    override fun setupUI() {
        super.setupUI()
        closeScreen()


    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()

    }


}