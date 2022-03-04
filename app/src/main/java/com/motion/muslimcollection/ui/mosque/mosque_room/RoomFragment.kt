package com.motion.muslimcollection.ui.mosque.mosque_room

import androidx.recyclerview.widget.LinearLayoutManager
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.mosque.mosque_room.adapter.RoomAdapter
import kotlinx.android.synthetic.main.fragment_room.*
import org.koin.android.ext.android.inject

class RoomFragment : BaseFragment(R.layout.fragment_room) {
    private val roomViewModel: RoomViewModel by inject()
    private lateinit var roomAdapter: RoomAdapter
    override fun setupObservers() {

    }

    override fun showConnectedState() {
        RecyclerView()
        initData()
        shareIdMaps()

    }

    override fun setupUI() {
        super.setupUI()
        btn_add_rm.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_roomFragment_to_addRoomFragment)
        }
    }

    override fun showBottomNavigation() {
        super.showBottomNavigation()

    }
    private fun shareIdMaps() {
        roomAdapter.onRoomItemClickListener = {
            val action = RoomFragmentDirections.actionRoomFragmentToRoomMapsFragment(it.id)
            (activity as MainActivity).navController.navigate(action)
        }
    }

    private fun RecyclerView() {
        with(recycler_room) {
            roomAdapter = RoomAdapter()
            adapter = roomAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun initData() {
        roomViewModel.laoding.observe(this) { loading_room.visible = it }
        roomViewModel.getRoomList()
        roomViewModel.list.observe(this) { it ->
            when (it.status) {
                Status.LOADING -> {
                    roomViewModel.laoding.postValue(true)
                }
                Status.SUCCESS -> {
                    roomViewModel.laoding.postValue(false)
                    it.data.let {
                        roomAdapter.submitList(it)
                    }
                }
                Status.ERROR -> {
                    roomViewModel.laoding.postValue(false)
                    context?.showMessage(it.message)
                }
            }
        }
    }

}