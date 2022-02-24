package com.motion.muslimcollection.ui.eat.cafe
import android.media.Image
import android.util.Log
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import kotlinx.android.synthetic.main.fragment_cafe.*
import kotlinx.android.synthetic.main.fragment_vacancy.*
import org.koin.android.ext.android.inject

class CafeFragment : BaseFragment(R.layout.fragment_cafe) {


    private val viewModel:CafeViewModel by inject()
    override fun setupObservers() {
        viewModel.getCafeList()
        viewModel.laoding.observe(this) { loadingCafe.visible = it }
        viewModel.getCafeList()
        viewModel.list.observe(this){ it ->
            when(it.status){
                Status.LOADING -> {
                    viewModel.laoding.postValue(true)
                }
                Status.SUCCESS -> {
                    viewModel.laoding.postValue(false)
                    it.data?.let {
                        Log.d("TAG", "setupObservers:$it ")
                        val image : ImageView= requireView().findViewById(R.id.imageCafe)
                        Glide.with(this).load(it[3].images).into(image)
                    }
                }
                Status.ERROR -> {
                    viewModel.laoding.postValue(false)
                    context?.showMessage(it.message)
                }
            }
        }
    }

    override fun showConnectedState() {

    }


}