package com.motion.muslimcollection.ui.mechet

import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_mechet.*


class MechetFragment : BaseFragment(R.layout.fragment_mechet) {
    override fun setupObservers() {
    }

    override fun showConnectedState() {
    }

    override fun saveOnBoard(b: Boolean) {
        TODO("Not yet implemented")
    }

    override fun setupUI() {
        super.setupUI()
        nextFr()
    }
    fun nextFr(){

        btn_mosqoe_next.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mechetFragment_to_mechetMapsFragment)
        }
        btn_room_next.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mechetFragment_to_prayer_RoomsFragment)
        }
        btn_coll_next.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mechetFragment_to_islamicCollegesFragment)
        }
        btn_mad_next.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mechetFragment_to_madrasahFragment)
        }
        btn_uni_nextt.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mechetFragment_to_islamic_universitiesFragment)
        }
        btn_lib_next.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mechetFragment_to_libraryFragment)
        }


    }


}
