package com.motion.muslimcollection.ui.vacancy

import android.text.Editable
import android.text.TextWatcher
import androidx.navigation.fragment.navArgs
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import kotlinx.android.synthetic.main.fragment_add_vacancy.*
import org.koin.android.ext.android.inject


class AddVacancyFragment : BaseFragment(R.layout.fragment_add_vacancy) {

    private val viewModel: VacancyViewModel by inject()
    val args :AddVacancyFragmentArgs by navArgs()

    override fun setupObservers() {
    }

    override fun showConnectedState() {
        nameVacancy.text = args.vacancy
        observeViewModel()
        shareRezItem()
        addTextChangeListeners()
    }

    private fun addTextChangeListeners() {
        phoneNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
viewModel.resetErrorInputPhoneNumber()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputEmail()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        fio.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputName()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        birthDay.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputBirthDay()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        town.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputTown()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        level.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputLevel()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        proWork.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputProWork()
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
            til_fio.error = massage

        }
        viewModel.errorInputBirthDay.observe(viewLifecycleOwner) {
                val massage = if (it){
                    getString(R.string.error)
                }else{
                    null
                }
                til_birthDay.error = massage

        }
        viewModel.errorInputTown.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_Town.error = massage

        }
        viewModel.errorInputPhoneNumber.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_phoneNumber.error = massage

        }
        viewModel.errorInputEmail.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_email.error = massage

        }
        viewModel.errorInputProWork.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_pro.error = massage
        }
        viewModel.errorInputLevelEducation.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_level.error = massage

        }
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner) {
            requireActivity().onBackPressed()
        }
    }

    private fun shareRezItem() {
        btnOkVacancy.setOnClickListener {
            addData(
                phoneNumber?.text.toString().trim(),
                email?.text.toString().trim(),
                fio?.text.toString().trim(),
                birthDay?.text.toString().trim(),
                town?.text.toString().trim(),
                proWork?.text.toString().trim(),
                level.text.toString().trim()
            )
        }
        closeScreen.setOnClickListener {
            activity?.onBackPressed()
        }
        exitAddVacancy.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun addData(
        phone:String?, email:String?
        , name:String, birthDay:String?
        , town:String?, proWork:String?, level:String?
    ) {
        viewModel.parseRezItem(phone, email, name, birthDay, town, proWork, level)
        // do something
    }

}