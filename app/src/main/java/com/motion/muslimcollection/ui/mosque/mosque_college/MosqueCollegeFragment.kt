package com.motion.muslimcollection.ui.mosque.mosque_college

import androidx.recyclerview.widget.LinearLayoutManager
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.mosque.mosque_college.adapter.CollegeAdapter
import com.motion.muslimcollection.ui.mosque.mosque_madrasah.MadrasahViewModel
import com.motion.muslimcollection.ui.mosque.mosque_madrasah.adapter.MadrasahAdapter
import kotlinx.android.synthetic.main.fragment_madrasah.*
import kotlinx.android.synthetic.main.fragment_mosque_college.*
import org.koin.android.ext.android.inject


class MosqueCollegeFragment : BaseFragment(R.layout.fragment_mosque_college) {
    private val collegeViewModel: MosqueCollegeViewModel by inject()
    private lateinit var collegeAdapter: CollegeAdapter
    override fun setupObservers() {

    }

    override fun showConnectedState() {
        RecyclerView()
        initData()
    }

    override fun setupUI() {
        super.setupUI()
        btn_add_cl.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mosqueCollegeFragment_to_addMosqueCollegeFragment)

        }
    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()
    }
    private fun RecyclerView() {
        with(recycler_college){
            collegeAdapter = CollegeAdapter()
            adapter = collegeAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
    private fun initData() {
        collegeViewModel.laoding.observe(this){loading_college.visible = it}
        collegeViewModel.getMosqueCollegeList()
        collegeViewModel.list.observe(this){ it ->
            when(it.status){
                Status.LOADING ->{
                    collegeViewModel.laoding.postValue(true)
                }
                Status.SUCCESS ->{
                    collegeViewModel.laoding.postValue(false)
                    it.data.let {
                        collegeAdapter.submitList(it)
                    }
                }
                Status.ERROR ->{
                    collegeViewModel.laoding.postValue(false)
                    context?.showMessage(it.message)
                }
            }
        }
    }

}