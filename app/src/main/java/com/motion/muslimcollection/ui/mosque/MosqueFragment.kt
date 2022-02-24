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

    override fun saveOnBoard(b: Boolean) {

    }

    private fun closeScreen(){
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                (activity as MainActivity).navController.navigate(R.id.action_mechetFragment_to_homeFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback)

    }

    override fun setupUI() {
        super.setupUI()
        next()
       closeScreen()
    }
    fun next(){

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
