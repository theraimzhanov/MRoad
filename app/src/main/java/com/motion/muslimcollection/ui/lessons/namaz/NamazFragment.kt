package com.motion.muslimcollection.ui.lessons.namaz

import android.media.MediaPlayer
import android.util.Log
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.ItemClickListener
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.lessons.LessonAdapter
import com.motion.muslimcollection.ui.lessons.LessonViewModel
import com.motion.muslimcollection.ui.lessons.LessonsFragmentDirections
import com.motion.muslimcollection.ui.lessons.namaz.adapter.AudioAdapter
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_lessons.*
import kotlinx.android.synthetic.main.fragment_namaz.*
import org.koin.android.ext.android.inject


class NamazFragment : BaseFragment(R.layout.fragment_namaz) {
    private val lessonViewModel: LessonViewModel by inject()
    private lateinit var _adapter: AudioAdapter
    val args: NamazFragmentArgs by navArgs()
    override fun setupObservers() {
    }
    override fun showConnectedState() {
        initRecyclerView()
        initData(args.post)
        _adapter.setItemClickListener(object : ItemClickListener {
            override fun onItemClick(position: Int) {
                val id = _adapter.currentList[position].id             /*  adapter.getList()[position].id*/
                val action = NamazFragmentDirections.actionNamazFragmentToPliyerFragment42(id)
                (activity as MainActivity).navController.navigate(action)
                Log.d("TAG", "onItemClick:$id ")
            }
        })
    }
    override fun setupUI() {
        super.setupUI()

    }
    override fun saveOnBoard(b: Boolean) {
    }
    private fun initRecyclerView() {
        with(recaudio){
            _adapter = AudioAdapter()
            adapter = _adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
    private fun initData(id: Int) {
       lessonViewModel.laodi.observe(this) { loading_lesson.visible = it }
        lessonViewModel.getCategoriaId(id)
        lessonViewModel.item.observe(this){ it ->
            when(it.status){
                Status.LOADING -> {
                    lessonViewModel.laodi.postValue(true)
                }
                Status.SUCCESS -> {
                    lessonViewModel.laodi.postValue(false)
                    it.data?.let {
                        _adapter.submitList(it.lessons)

                    }
                }
                Status.ERROR -> {
                    lessonViewModel.laodi.postValue(false)
                    context?.showMessage(it.message)
                }
            }
        }
    }


}