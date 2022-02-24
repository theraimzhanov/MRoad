package com.motion.muslimcollection.ui.vacancy

import android.text.Editable
import android.text.TextWatcher
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import kotlinx.android.synthetic.main.fragment_add_vacancy.*
import org.koin.android.ext.android.inject


class AddVacancyFragment : BaseFragment(R.layout.fragment_add_vacancy) {

    private val viewModel: VacancyViewModel by inject()

    override fun setupObservers() {
    }

    override fun saveOnBoard(b: Boolean) {
    }


    override fun showConnectedState() {
        observeViewModel()
        addVacancy()
        addTextChangeListeners()
    }

    private fun addTextChangeListeners() {
        nameWorker.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
viewModel.resetErrorInputName()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        nameCompany.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputCompany()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        requirements.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputRequirements()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        salary.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputSalary()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        obligation.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputObligation()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        religion.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputReligion()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }


    private fun observeViewModel() {
        viewModel.errorInputName.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_nameWorker.error = massage

        }
        viewModel.errorInputCompany.observe(viewLifecycleOwner) {
                val massage = if (it){
                    getString(R.string.error)
                }else{
                    null
                }
                til_nameCompany.error = massage

        }
        viewModel.errorInputRequirements.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_requirements.error = massage

        }
        viewModel.errorInputSalary.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_salary.error = massage

        }
        viewModel.errorInputObligation.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_obligation.error = massage

        }
        viewModel.errorInputReligion.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_religion.error = massage

        }
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner) {
            requireActivity().onBackPressed()
        }
    }

    private fun addVacancy() {
        btnAddVacancy.setOnClickListener {
            addData(
                nameWorker?.text.toString().trim(),
                nameCompany?.text.toString().trim(),
                requirements?.text.toString().trim(),
                salary?.text.toString().trim(),
                obligation?.text.toString().trim(),
                religion?.text.toString().trim()
            )
        }
    }

    private fun addData(
        name: String?,
        company: String?,
        requirements: String,
        salary: String?,
        obligation: String?,
        religion: String?
    ) {
        viewModel.laoding.observe(this) { loadingVacancy.visible = it }
        viewModel.addVacancyItem(name, company, requirements, salary, obligation, religion)
        viewModel.add.observe(this) { it ->
            when (it.status) {
                Status.LOADING -> {
                    viewModel.laoding.postValue(true)
                }
                Status.SUCCESS -> {
                    viewModel.laoding.postValue(false)

                    context?.showMessage(it.message)

                }
                Status.ERROR -> {
                    viewModel.laoding.postValue(false)
                    context?.showMessage(it.message)
                }
            }
        }
    }

}