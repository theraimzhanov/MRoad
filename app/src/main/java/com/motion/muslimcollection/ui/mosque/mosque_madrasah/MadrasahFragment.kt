package com.motion.muslimcollection.ui.mosque.mosque_madrasah

import androidx.recyclerview.widget.LinearLayoutManager
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.mosque.mosque_madrasah.adapter.MadrasahAdapter
import com.motion.muslimcollection.ui.mosque.mosques.MosqueViewModel
import com.motion.muslimcollection.ui.mosque.mosques.adapter.MosqueAdapter
import com.motion.muslimcollection.ui.vacancy.VacancyFragmentDirections
import kotlinx.android.synthetic.main.fragment_library.*
import kotlinx.android.synthetic.main.fragment_madrasah.*
import kotlinx.android.synthetic.main.fragment_mosques.*
import org.koin.android.ext.android.inject

class MadrasahFragment : BaseFragment(R.layout.fragment_madrasah) {
    private val madrasahViewModel: MadrasahViewModel by inject()
    private lateinit var madrasahAdapter: MadrasahAdapter
    override fun setupObservers() {
    }

    override fun showConnectedState() {
        RecyclerView()
        initData()
        shareIdMadrasah()
    }
    private fun shareIdMadrasah() {
        madrasahAdapter.onMadrasahItemClickListener = {
            val action = MadrasahFragmentDirections.actionMadrasahFragmentToMadrasahMapsFragment(it.id)
            (activity as MainActivity).navController.navigate(action)
        }
    }
    override fun setupUI() {
        super.setupUI()
        btn_add_md.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_madrasahFragment_to_addMadrasahFragment)
        }

    }
    private fun RecyclerView() {
        with(recycler_madrasah){
            madrasahAdapter = MadrasahAdapter()
            adapter = madrasahAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
    private fun initData() {
        madrasahViewModel.laoding.observe(this){loading_madrasah.visible = it}
        madrasahViewModel.getMadrasahList()
        madrasahViewModel.list.observe(this){ it ->
            when(it.status){
                Status.LOADING ->{
                    madrasahViewModel.laoding.postValue(true)
                }
                Status.SUCCESS ->{
                    madrasahViewModel.laoding.postValue(false)
                    it.data.let {
                        madrasahAdapter.submitList(it)
                    }
                }
                Status.ERROR ->{
                    madrasahViewModel.laoding.postValue(false)
                    context?.showMessage(it.message)
                }
            }
        }
    }

}