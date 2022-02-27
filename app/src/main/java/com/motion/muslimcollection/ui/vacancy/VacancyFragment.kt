package com.motion.muslimcollection.ui.vacancy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.vacancy.adapter.VacancyAdapter
import kotlinx.android.synthetic.main.fragment_vacancy.*
import org.koin.android.ext.android.inject
import javax.net.ssl.SSLEngineResult


class VacancyFragment : BaseFragment(R.layout.fragment_vacancy) {

    private val viewModel: VacancyViewModel by inject()
    private lateinit var vacancyAdapter:VacancyAdapter

    override fun setupObservers() {
    }

    override fun showConnectedState() {
        initRecyclerView()
        initData()
        shareIdVacancy()
        back()
    }

    private fun back() {
        exitVacancy.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun shareIdVacancy() {
        vacancyAdapter.onVacancyItemClickListener = {
          val action = VacancyFragmentDirections.actionVacancyFragmentToWorkFragment(it.id)
            (activity as MainActivity).navController.navigate(action)
        }
    }

    private fun initRecyclerView() {
        with(recyclerViewVacancy){
            vacancyAdapter = VacancyAdapter()
            adapter = vacancyAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }



    private fun initData() {
        viewModel.laoding.observe(this) { progressOfVacancy.visible = it }
        viewModel.getVacancyList()
        viewModel.list.observe(this){ it ->
            when(it.status){
                Status.LOADING -> {
                    viewModel.laoding.postValue(true)
                }
                Status.SUCCESS -> {
                    viewModel.laoding.postValue(false)
                    it.data?.let {
                      vacancyAdapter.submitList(it)
                    }
                }
                Status.ERROR -> {
                    viewModel.laoding.postValue(false)
                    context?.showMessage(it.message)
                }
            }
        }
    }
}