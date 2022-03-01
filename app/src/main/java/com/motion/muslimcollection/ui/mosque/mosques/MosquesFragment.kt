package com.motion.muslimcollection.ui.mosque.mosques

import androidx.recyclerview.widget.LinearLayoutManager
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.databinding.FragmentMosquesBinding
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.mosque.mosques.adapter.MosqueAdapter
import kotlinx.android.synthetic.main.fragment_add_mechet.*
import kotlinx.android.synthetic.main.fragment_mosques.*
import org.koin.android.ext.android.inject

class MosquesFragment : BaseFragment(R.layout.fragment_mosques) {
    private val mosquesViewModel: MosqueViewModel by inject()
    private lateinit var mosqueAdapter: MosqueAdapter
    override fun setupObservers() {
    }
    override fun showConnectedState() {
        RecyclerView()
        initData()

    }
    private fun RecyclerView() {
        with(recycler_mosque){
            mosqueAdapter = MosqueAdapter(requireContext())
            adapter = mosqueAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
    private fun initData() {
        mosquesViewModel.laoding.observe(this){loading_mosque.visible = it}
        mosquesViewModel.getMosqueList()
        mosquesViewModel.list.observe(this){ it ->
            when(it.status){
                Status.LOADING ->{
                    mosquesViewModel.laoding.postValue(true)
                }
                Status.SUCCESS ->{
                    mosquesViewModel.laoding.postValue(false)
                    it.data.let {
                        mosqueAdapter.submitList(it)
                    }
                }
                Status.ERROR ->{
                    mosquesViewModel.laoding.postValue(false)
                    context?.showMessage(it.message)
                }
            }
        }
    }
    override fun setupUI() {
        super.setupUI()
        next()
    }
    fun next() {
        btn_add_ms.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mosquesFragment_to_addMosqueFragment2)
        }

    }

    override fun showBottomNavigation() {
        super.showBottomNavigation()
    }
}