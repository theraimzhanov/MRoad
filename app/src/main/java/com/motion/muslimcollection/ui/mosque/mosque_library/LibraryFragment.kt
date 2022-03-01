package com.motion.muslimcollection.ui.mosque.mosque_library

import androidx.recyclerview.widget.LinearLayoutManager
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.mosque.mosque_library.adapter.LibraryAdapter
import com.motion.muslimcollection.ui.mosque.mosques.MosqueViewModel
import com.motion.muslimcollection.ui.mosque.mosques.adapter.MosqueAdapter
import kotlinx.android.synthetic.main.fragment_library.*
import kotlinx.android.synthetic.main.fragment_mosques.*
import org.koin.android.ext.android.inject

class LibraryFragment : BaseFragment(R.layout.fragment_library) {
    private val lbViewModel: LibraryViewModel by inject()
    private lateinit var libraryAdapter: LibraryAdapter
    override fun setupObservers() {
    }

    override fun showConnectedState() {
        RecyclerView()
        initData()
    }

    override fun setupUI() {
        super.setupUI()
    }
    private fun RecyclerView() {
        with(recycler_library){
            libraryAdapter = LibraryAdapter()
            adapter = libraryAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
    private fun initData() {
        lbViewModel.laoding.observe(this){loading_library.visible = it}
        lbViewModel.getLibraryList()
        lbViewModel.list.observe(this){ it ->
            when(it.status){
                Status.LOADING ->{
                    lbViewModel.laoding.postValue(true)
                }
                Status.SUCCESS ->{
                    lbViewModel.laoding.postValue(false)
                    it.data.let {
                        libraryAdapter.submitList(it)
                    }
                }
                Status.ERROR ->{
                    lbViewModel.laoding.postValue(false)
                    context?.showMessage(it.message)
                }
            }
        }
    }
}