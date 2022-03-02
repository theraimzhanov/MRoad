package com.motion.muslimcollection.ui.eat.cafe
import android.content.Intent
import android.net.Uri
import android.text.Editable
import android.text.TextWatcher
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_add_cafe.*
import kotlinx.android.synthetic.main.fragment_add_vacancy.*
import org.koin.android.ext.android.inject
import java.util.logging.Handler as Handler1


class AddCafeFragment : BaseFragment(R.layout.fragment_add_cafe) {


    private var uriImage :Uri? =null
    private val viewModel: CafeViewModel by inject()
    override fun setupObservers() {

    }

    override fun showConnectedState() {
observeViewModel()
        addTextChangeListeners()
    }



    override fun setupUI() {
        super.setupUI()
        navigate()
    }

    private fun navigate() {
        exitAddCafe.setOnClickListener {
            activity?.onBackPressed()
        }
        addImageOfCafe.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Выбирайте фото"), GET_IMAGE)
        }
        btnAddCafeItem.setOnClickListener {
            var prayer:Boolean = false
            var certificate:Boolean = false
            prayer = etTextPrayerOfCafe.text!!.equals(getString(R.string.yes))
            certificate = etTextCertificateOfCafe.text!!.equals(getString(R.string.yes))
          viewModel.postCafeItem(etTextNameOfCafe.text.toString().trim(),
              etTextLocationOfCafe.text.toString().trim(),
              etTextPhoneOfCafe.text.toString().trim(),certificate,prayer)
        }
    }
   companion object{
       private const val GET_IMAGE = -1
   }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GET_IMAGE) {
            if (data != null) {
                uriImage = data.data;
            }
        }
    }

    private fun observeViewModel() {
        viewModel.errorInputName.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_nameOfCafe.error = massage
        }
        viewModel.errorInputLocation.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_locationOfCafe.error = massage

        }
        viewModel.errorInputPhoneNumber.observe(viewLifecycleOwner) {
            val massage = if (it){
                getString(R.string.error)
            }else{
                null
            }
            til_phoneOfCafe.error = massage
        }
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner) {
            activity?.onBackPressed()
        }
    }
    private fun addTextChangeListeners() {
        etTextNameOfCafe.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputName()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        etTextPhoneOfCafe.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputPhone()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        etTextLocationOfCafe.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputLocation()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

}