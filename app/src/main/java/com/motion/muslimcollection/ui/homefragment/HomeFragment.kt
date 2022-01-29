package com.motion.muslimcollection.ui.homefragment

import android.view.*
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment(R.layout.fragment_home) {
    override fun setupObservers() {
        setHasOptionsMenu(true)
    }
    override fun showConnectedState() {
    }
    override fun setupUI() {
        super.setupUI()

    }

    override fun showBottomNavigation() {
        super.showBottomNavigation()
        requireActivity().toolbar_text.text = resources.getString(R.string.home)
    }
      override fun onCreateOptionsMenu( menu: Menu, inflater: MenuInflater) {
       inflater.inflate(R.menu.menu_item, menu)
       super.onCreateOptionsMenu(menu, inflater)
   }
   override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when (item.itemId) {
           R.id.menu_res -> {

               true
           }
           R.id.menu_set -> {

               true
           }
           R.id.menu_share -> {

               true
           }
           R.id.menu_app -> {

               true
           }
           else -> super.onOptionsItemSelected(item)
       }
   }

}


