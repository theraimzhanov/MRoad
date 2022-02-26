package com.motion.muslimcollection.ui.mosque.mosques

import androidx.recyclerview.widget.LinearLayoutManager
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.ItemClickListener
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.mosque.MosqueFragmentDirections
import com.motion.muslimcollection.ui.mosque.mosques.adapter.MosqueAdapter
import kotlinx.android.synthetic.main.fragment_mosques.*
import kotlinx.android.synthetic.main.list_mosque.*
import org.koin.android.ext.android.inject

class MosquesFragment : BaseFragment(R.layout.fragment_mosques) {
    private val mosqueviewModel: MosqueViewModel by inject()
    private lateinit var mosqueAdapter: MosqueAdapter

    override fun setupObservers() {
    }
    override fun showConnectedState() {
        RecyclerView()
        initData()
        mosqueAdapter.setItemClickListener(object :ItemClickListener{
            override fun onItemClick(position: Int) {
                val id = mosqueAdapter.currentList[position].id
                val action = MosqueFragmentDirections.actionMosqueFragmentToAddMosqueFragment2()
                (activity as MainActivity).navController.navigate(action)
            }
        })
    }
    private fun RecyclerView() {
        with(recycler_mosque){
            mosqueAdapter = MosqueAdapter()
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
    private fun initData() {
        mosqueviewModel.laoding.observe(this){loading_mosque.visible = it}
        mosqueviewModel.list.observe(this){ it ->
            when(it.status){
                Status.LOADING ->{
                    mosqueviewModel.laoding.postValue(true)
                }
                Status.SUCCESS ->{
                    mosqueviewModel.laoding.postValue(true)
                    it.data.let {
                        mosqueAdapter.submitList(it)
                    }
                }
                Status.ERROR ->{
                    mosqueviewModel.laoding.postValue(true)
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
    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()
    }
}