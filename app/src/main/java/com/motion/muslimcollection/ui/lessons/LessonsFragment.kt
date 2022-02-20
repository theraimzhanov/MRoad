package com.motion.muslimcollection.ui.lessons


import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.ItemClickListener
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.vacancy.adapter.VacancyAdapter
import kotlinx.android.synthetic.main.fragment_lessons.*
import kotlinx.android.synthetic.main.fragment_vacancy.*
import kotlinx.android.synthetic.main.listlessoncategories.*
import org.koin.android.ext.android.inject


class LessonsFragment : BaseFragment(R.layout.fragment_lessons) {
    private val lessonViewModel: LessonViewModel by inject()
    private lateinit var lessonAdapter: LessonAdapter
    override fun saveOnBoard(b: Boolean) {
    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()
    }
    override fun setupObservers() {
    }
    override fun showConnectedState() {



        initRecyclerView()
        initData()
        lessonAdapter.setItemClickListener(object :ItemClickListener{
            override fun onItemClick(position: Int) {
                val id = lessonAdapter.currentList[position].id             /*  adapter.getList()[position].id*/
                val action = LessonsFragmentDirections.actionLessonsFragmentToNamazFragment(id)
                (activity as MainActivity).navController.navigate(action)
                Log.d("TAG", "onItemClick:$id ")
            }

        })

    }
    private fun initRecyclerView() {
        with(recycler_codes){
            lessonAdapter = LessonAdapter()
            adapter = lessonAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
    private fun initData() {
        lessonViewModel.laodi.observe(this) { loading_codes.visible = it }
        lessonViewModel.getLessonAll()
        lessonViewModel.list.observe(this){ it ->
            when(it.status){
                Status.LOADING -> {
                    lessonViewModel.laodi.postValue(true)
                }
                Status.SUCCESS -> {
                    lessonViewModel.laodi.postValue(false)
                    it.data?.let {
                        lessonAdapter.submitList(it)
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

