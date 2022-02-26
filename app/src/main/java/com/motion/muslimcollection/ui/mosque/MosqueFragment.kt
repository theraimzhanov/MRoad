package com.motion.muslimcollection.ui.mosque

import androidx.activity.OnBackPressedCallback
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_mosque.*

class MosqueFragment : BaseFragment(R.layout.fragment_mosque) {
    override fun setupObservers() {
    }

    override fun showConnectedState() {
    }

    override fun setupUI() {
        super.setupUI()
        next()
    }
    fun next(){
        btn_madrasah.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mosqueFragment_to_madrasahFragment)
        }
        btn_mosques_.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mosqueFragment_to_mosquesFragment)
        }
        btn_room.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mosqueFragment_to_roomFragment)
        }
        btn_college.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mosqueFragment_to_mosqueCollegeFragment)
        }
        btn_library.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mosqueFragment_to_libraryFragment)
        }
        btn_university.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mosqueFragment_to_universityFragment)
        }

    }


}
