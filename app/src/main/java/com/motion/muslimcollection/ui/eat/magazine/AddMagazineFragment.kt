package com.motion.muslimcollection.ui.eat.magazine
import android.text.Editable
import android.text.TextWatcher
import android.widget.RadioButton
import android.widget.RadioGroup
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.model.cafe_model.MagazineItem
import com.motion.muslimcollection.network.result.Status
import kotlinx.android.synthetic.main.fragment_add_magazine.*
import kotlinx.android.synthetic.main.fragment_add_vacancy.*
import kotlinx.android.synthetic.main.fragment_vacancy.*
import org.koin.android.ext.android.inject


class AddMagazineFragment : BaseFragment(R.layout.fragment_add_magazine) {
    private val viewModel:MagazineViewModel by inject()

    override fun setupObservers() {

    }

    override fun showConnectedState() {
addTextChangeListeners()
        observeViewModel()
        navigate()
    }

    private fun navigate() {
        btnAddMagazineItem.setOnClickListener {
            addMagazineItem(etTextNameOfName.text.toString(),
                etTextLocationOfMagazine.text.toString(),
                etTextPhoneOfMagazine.text.toString(),checkData(rg_mg_certificate)
                ,checkData(rg_mg_prayer_room),"")
        }
        addImageOfMagazine.setOnClickListener {

        }
        exitAddMagazine.setOnClickListener {
            activity?.onBackPressed()
        }
    }


    override fun setupUI() {
        super.setupUI()
    }
    private fun addTextChangeListeners() {
        etTextPhoneOfMagazine.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputPhoneNumber()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        etTextLocationOfMagazine.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputAddress()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        etTextNameOfName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputName()
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
            til_nameOfMagazine.error = massage

        }
        viewModel.errorInputAddress.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_locationOfMagazine.error = massage
        }
        viewModel.errorInputPhoneNumber.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_phoneOfMagazine.error = massage
        }
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner) {

        }
    }

    private fun addMagazineItem( name:String?, address:String?
                                 , phone:String,certificate:Boolean,msRoom:Boolean,img:String?){
        if (img != null){
            viewModel.postMagazineItem(name, phone, address, certificate, msRoom,MagazineItem.EMPTY_PAGE,"8:00")
        } else{
            viewModel.postMagazineItem(name, phone, address, certificate, msRoom, img,"8:00")
        }
    }
    private fun checkData(radioGroup: RadioGroup):Boolean{
       val button =activity?.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
         var checked = false
        button?.let {
            checked = button.text.equals(resources.getString(R.string.hint_yes))
        }
        return checked
    }
}