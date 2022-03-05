package com.motion.muslimcollection.ui.eat.magazine

import androidx.recyclerview.widget.LinearLayoutManager
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.eat.magazine.adapter.MagazineAdapter
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.vacancy.VacancyFragmentDirections
import com.motion.muslimcollection.ui.vacancy.VacancyViewModel
import com.motion.muslimcollection.ui.vacancy.adapter.VacancyAdapter
import kotlinx.android.synthetic.main.fragment_magazine.*
import kotlinx.android.synthetic.main.fragment_vacancy.*
import org.koin.android.ext.android.inject


class MagazineFragment : BaseFragment( R.layout.fragment_magazine) {

    private val viewModel: MagazineViewModel  by inject()
    private lateinit var magazineadapter: MagazineAdapter
    override fun setupObservers() {
    }

    override fun showConnectedState() {
        initRecyclerView()
        shareIdVacancy()
        initData()
    }

    private fun shareIdVacancy() {
        magazineadapter.onMagazineItemClickListener = {
        }
    }

    private fun initData() {
        viewModel.laoding.observe(this) { loadingMagazine.visible = it }
        viewModel.getMagazineList()
        viewModel.list.observe(this){ it ->
            when(it.status){
                Status.LOADING -> {
                    viewModel.laoding.postValue(true)
                }
                Status.SUCCESS -> {
                    viewModel.laoding.postValue(false)
                    it.data?.let {
                        magazineadapter.submitList(it)
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
        with(recyclerMagazine){
            magazineadapter = MagazineAdapter()
            adapter = magazineadapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun setupUI() {
        super.setupUI()
        navigate()
    }

    private fun navigate() {
        exitMagazine.setOnClickListener {
           activity?.onBackPressed()
        }
        layout_addMagazine.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_magazineFragment_to_addMagazineFragment)
        }
    }


}