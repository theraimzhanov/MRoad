package com.motion.muslimcollection.ui.eat.fastfood
import androidx.recyclerview.widget.LinearLayoutManager
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.eat.fastfood.adapter.FastFoodAdapter
import com.motion.muslimcollection.ui.eat.magazine.MagazineViewModel
import com.motion.muslimcollection.ui.eat.magazine.adapter.MagazineAdapter
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_fast_food.*
import kotlinx.android.synthetic.main.fragment_magazine.*
import org.koin.android.ext.android.inject


class FastFoodFragment : BaseFragment(R.layout.fragment_fast_food) {

    private val viewModel: FastFoodViewModel by inject()
    private lateinit var fastFood: FastFoodAdapter

    override fun setupObservers() {
    }

    override fun showConnectedState() {
        initData()
        initRecyclerView()
shareIdVacancy()
    }



    override fun setupUI() {
        super.setupUI()
        navigate()
    }
    private fun initData() {
        viewModel.laoding.observe(this) { loadingFastFood.visible = it }
        viewModel.getFastFoodList()
        viewModel.list.observe(this){ it ->
            when(it.status){
                Status.LOADING -> {
                    viewModel.laoding.postValue(true)
                }
                Status.SUCCESS -> {
                    viewModel.laoding.postValue(false)
                    it.data?.let {
                        fastFood.submitList(it)
                    }
                }
                Status.ERROR -> {
                    viewModel.laoding.postValue(false)
                    context?.showMessage(it.message)
                }
            }
        }
    }
    private fun initRecyclerView() {
        with(recyclerFastFood) {
            fastFood = FastFoodAdapter(requireContext())
            adapter = fastFood
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
    private fun navigate() {
        exitFastFood.setOnClickListener {
            activity?.onBackPressed()
        }
        layout_addFastFood.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_fastFoodFragment_to_addFastfoodFragment)
        }
    }
    private fun shareIdVacancy() {
        fastFood.onFastFoodItemClickListener = {
        }
    }
}