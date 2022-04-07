package com.motion.muslimcollection.ui.mosque.mosque_university


import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.mosque.location.MapsIntentActivity
import com.motion.muslimcollection.ui.mosque.mosque_university.adapter.AdapterUniversities
import kotlinx.android.synthetic.main.fragment_mosque_university.*
import org.koin.android.ext.android.inject

class UniversityFragment : BaseFragment(R.layout.fragment_mosque_university) {

    private val universityViewModel: UniversityViewModel by inject()
    private lateinit var unAdapter: AdapterUniversities
    override fun setupObservers() {

    }

    override fun showConnectedState() {
        RecyclerView()
        initData()
        shareIdMaps()
    }
    private fun initData() {
        universityViewModel.laoding.observe(this) { loading_university.visible = it }
        universityViewModel.getUniversityList()
        universityViewModel.list.observe(this) { it ->
            when (it.status) {
                Status.LOADING -> {
                    universityViewModel.laoding.postValue(true)
                }
                Status.SUCCESS -> {
                    universityViewModel.laoding.postValue(false)
                    it.data.let {
                        unAdapter.submitList(it)
                    }
                }
                Status.ERROR -> {
                    universityViewModel.laoding.postValue(false)
                    context?.showMessage(it.message)
                }
            }
        }
    }
    private fun RecyclerView() {
        with(recycler_university) {
            unAdapter = AdapterUniversities()
            adapter = unAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
    private fun shareIdMaps() {
        unAdapter.onUniversityItemClickListener = {
            val intent = MapsIntentActivity.getLocationIntent(requireContext()
                ,it.name!!,it.latitude,it.longitude)
            startActivity(intent)
            Log.d("TAG", "shareIdMadrasah:$it ")
        }
    }


    override fun setupUI() {
        super.setupUI()

        btn_add_un.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_universityFragment_to_addUniversityFragment)
        }
    }


}