package com.motion.muslimcollection.ui.eat.cafe
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.eat.cafe.adapter.CafeAdapter
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.vacancy.VacancyFragmentDirections
import com.motion.muslimcollection.ui.vacancy.adapter.VacancyAdapter
import kotlinx.android.synthetic.main.fragment_cafe.*
import kotlinx.android.synthetic.main.fragment_vacancy.*
import org.koin.android.ext.android.inject

class CafeFragment : BaseFragment(R.layout.fragment_cafe) {


    private val viewModel:CafeViewModel by inject()
    private lateinit var cafeAdapter: CafeAdapter
    override fun setupObservers() {
    }

    override fun showConnectedState() {
        initRecyclerView()
        initData()
        shareCafeItem()
    }

    private fun initData() {
        viewModel.getCafeList()
        viewModel.laoding.observe(this) { loadingCafe.visible = it }
        viewModel.list.observe(this){ it ->
            when(it.status){
                Status.LOADING -> {
                    viewModel.laoding.postValue(true)
                }
                Status.SUCCESS -> {
                    viewModel.laoding.postValue(false)
                    it.data?.let {
                        cafeAdapter.submitList(it)
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
        navigate()
    }
    private fun navigate() {
        layout_add.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_cafeFragment_to_addCafeFragment)
        }
        exitCafe.setOnClickListener {
           activity?.onBackPressed()
        }
    }
    private fun initRecyclerView() {
        with(recyclerCafe){
            cafeAdapter = CafeAdapter(requireContext())
            adapter = cafeAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
    private fun shareCafeItem() {
        cafeAdapter.onCafeItemClickListener = {

        }
    }

}