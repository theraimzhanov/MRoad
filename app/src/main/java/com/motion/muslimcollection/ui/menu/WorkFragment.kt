package com.motion.muslimcollection.ui.menu

import androidx.navigation.fragment.navArgs
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.vacancy.VacancyViewModel
import kotlinx.android.synthetic.main.fragment_work.*
import org.koin.android.ext.android.inject


class WorkFragment : BaseFragment(R.layout.fragment_work) {

    val arg:WorkFragmentArgs by navArgs()
    private var name:String? = null
    private val viewModel: VacancyViewModel by inject()

    override fun setupObservers() {
    }

    override fun showConnectedState() {
        initData(arg.vacancyId)
        navigate()
    }

    private fun navigate() {
        exitWork.setOnClickListener {
            activity?.onBackPressed()
        }
        likeVacancy.setOnClickListener {
            val action = name?.let { it1 ->
                WorkFragmentDirections.actionWorkFragmentToAddVacancyFragment(
                    it1
                )
            }
            action?.let { it1 -> (activity as MainActivity).navController.navigate(it1) }
        }
    }

    private fun initData(id:Int) {
        viewModel.laoding.observe(viewLifecycleOwner) { loadingWork.visible = it }
        viewModel.getVacancyItem(id)
        viewModel.item.observe(viewLifecycleOwner){ it ->
            when(it.status){
                Status.LOADING -> {
                    viewModel.laoding.postValue(true)
                }
                Status.SUCCESS -> {
                    viewModel.laoding.postValue(false)
                    it.data?.let {
                        name = it.name
                        workToolbarText.text = it.name
                        companyForVacancy.text = it.company
                        nameForVacancy.text = it.name
                        salaryForVacancy.text = it.salary.toString()
                        requirementsWork.text = it.requirements
                        dutiesWork.text = it.duties
                        conditionsWork.text = it.conditions
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