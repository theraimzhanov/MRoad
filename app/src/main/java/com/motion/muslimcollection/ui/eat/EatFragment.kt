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

    override fun setupUI() {
        super.setupUI()
        navigate()
    }
    private fun navigate() {
        btn_cafe.setOnClickListener { (activity as MainActivity).navController.navigate(R.id.action_eatFragment_to_cafeFragment) }
        btn_restaurant.setOnClickListener { (activity as MainActivity).navController.navigate(R.id.action_eatFragment_to_restaurantFragment) }
        btn_fast_food.setOnClickListener { (activity as MainActivity).navController.navigate(R.id.action_eatFragment_to_fastFoodFragment) }
        btn_shop.setOnClickListener  { (activity as MainActivity).navController.navigate(R.id.action_eatFragment_to_magazineFragment) }
        btn_e_code.setOnClickListener { context?.showMessage("Пока не можеть добавить катогория") }
    }
}



