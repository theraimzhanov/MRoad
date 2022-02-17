package com.motion.muslimcollection.ui.vacancy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.model.vacancies.VacancyItem
import com.motion.muslimcollection.network.result.Status
import org.koin.android.ext.android.inject


class AddVacancyFragment : BaseFragment(R.layout.fragment_add_vacancy) {

    private val viewModel:VacancyViewModel by inject()

    override fun setupObservers() {
    }
    override fun saveOnBoard(b: Boolean) {
    }


    override fun showConnectedState() {
        observeViewModel()
    }

    private fun observeViewModel() {
     viewModel.errorInputName.observe(viewLifecycleOwner){
        if (it){
            context?.showMessage("Заполните фио")
        }
     }
        viewModel.errorInputCompany.observe(viewLifecycleOwner){
            if (it){
                context?.showMessage("Заполните компания")
            }
        }
        viewModel.errorInputRequirements.observe(viewLifecycleOwner){
            if (it){
                context?.showMessage("Заполните требования")
            }
        }
        viewModel.errorInputSalary.observe(viewLifecycleOwner){
            if (it){
                context?.showMessage("Заполните зп")
            }
        }
        viewModel.errorInputObligation.observe(viewLifecycleOwner){
            if (it){
                context?.showMessage("Заполните обьязанность")
            }
        }
        viewModel.errorInputReligion.observe(viewLifecycleOwner){
            if (it){
                context?.showMessage("Заполните условия для религиозных")
            }
        }
    }

    private fun addData(name:String?,company:String?
                        ,requirements:String,salary:String?
                        ,obligation:String?,religion:String?) {
        viewModel.laoding.observe(this) {  }
        viewModel.addVacancyItem(name, company, requirements, salary, obligation, religion)
        viewModel.add.observe(this){ it ->
            when(it.status){
                Status.LOADING -> {
                    viewModel.laoding.postValue(true)
                }
                Status.SUCCESS -> {
                    viewModel.laoding.postValue(false)
                }
                Status.ERROR -> {
                    viewModel.laoding.postValue(false)
                    context?.showMessage(it.message)
                }
            }
        }
    }

}