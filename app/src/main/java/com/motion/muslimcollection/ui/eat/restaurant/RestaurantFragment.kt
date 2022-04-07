package com.motion.muslimcollection.ui.eat.restaurant


import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.eat.restaurant.adapter.RestaurantAdapter
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.mosque.location.MapsIntentActivity
import kotlinx.android.synthetic.main.fragment_restaurant.*
import org.koin.android.ext.android.inject

class RestaurantFragment : BaseFragment(R.layout.fragment_restaurant) {

    private val viewModel: RestaurantViewModel by inject()
    private lateinit var restaurantAdapter: RestaurantAdapter

    override fun setupObservers() {

    }

    override fun showConnectedState() {
        initData()
    }

    private fun initData() {
        viewModel.laoding.observe(this) { loadingRestaurant.visible = it }
        viewModel.getRestaurantList()
        viewModel.list.observe(this) { it ->
            when (it.status) {
                Status.LOADING -> {
                    viewModel.laoding.postValue(true)
                }
                Status.SUCCESS -> {
                    viewModel.laoding.postValue(false)
                    it.data?.let {
                        restaurantAdapter.submitList(it)
                    }
                }
                Status.ERROR -> {
                    viewModel.laoding.postValue(false)
                    context?.showMessage(it.message)
                }
            }
        }
    }


    override fun setupUI() {
        super.setupUI()
        initRecyclerView()
        navigate()
        shareIdVacancy()
    }

    private fun initRecyclerView() {
        with(recyclerRestaurant) {
            restaurantAdapter = RestaurantAdapter(requireContext())
            adapter = restaurantAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun navigate() {
        exitRestaurant.setOnClickListener {
            activity?.onBackPressed()
        }
        layout_addRestaurant.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_restaurantFragment_to_addRestaurantFragment)
        }
    }

    private fun shareIdVacancy() {
        restaurantAdapter.onItemRestaurantClickListener = {
            val intent = MapsIntentActivity.getLocationIntent(requireContext()
                ,it.name,it.latitude.toString(),it.longitude.toString())
            startActivity(intent)
            Log.d("TAG", "shareIdMadrasah:$it ")
        }
    }

}