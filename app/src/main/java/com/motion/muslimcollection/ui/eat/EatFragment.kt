package com.motion.muslimcollection.ui.eat

import androidx.activity.OnBackPressedCallback
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_eat.*


class EatFragment : BaseFragment(R.layout.fragment_eat) {
    override fun setupObservers() {
    }

    override fun showConnectedState() {
    }

    override fun saveOnBoard(b: Boolean) {

    }

    private fun closeScreen() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                (activity as MainActivity).navController.navigate(R.id.action_eatFragment_to_homeFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
//closeScreen()//setupUI()
    }

    override fun setupUI() {
        super.setupUI()
        closeScreen()
        navigate()
    }

    private fun navigate() {
        btn_cofe_next.setOnClickListener {
            (activity as MainActivity)
                .navController.navigate(R.id.action_eatFragment_to_cafeFragment)
        }
        btn_restoran_next.setOnClickListener { (activity as MainActivity)
            .navController.navigate(R.id.action_eatFragment_to_restaurantFragment) }
        btn_shop_next.setOnClickListener { (activity as MainActivity)
            .navController.navigate(R.id.action_eatFragment_to_shopsFragment) }
        btn_fastfud_next.setOnClickListener { (activity as MainActivity)
            .navController.navigate(R.id.action_eatFragment_to_fast_foodFragment) }
        btn_e_dobavki_nextt.setOnClickListener{
            context?.showMessage("Пока не можеть добавить катогория") }
    }

    override fun showBottomNavigation() {
        super.showBottomNavigation()


    }


}