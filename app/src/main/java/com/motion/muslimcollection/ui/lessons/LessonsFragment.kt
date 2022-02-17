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
import kotlinx.android.synthetic.main.fragment_lessons.*
import kotlinx.android.synthetic.main.listlessoncategories.*
import org.koin.android.ext.android.inject


class LessonsFragment : BaseFragment(R.layout.fragment_lessons) {


    private val lessonViewModel: LessonViewModel by inject()
    private lateinit var adapter: AdapterLessonCategories

    override fun setupObservers() {
    }

    override fun saveOnBoard(b: Boolean) {
    }

    override fun setupUI() {
        super.setupUI()
    }

    override fun showBottomNavigation() {
        super.showBottomNavigation()

    override fun setupObservers() {

    }

    override fun showConnectedState() {

    }

    override fun saveOnBoard(b: Boolean) {
    }

    override fun showConnectedState() {
        val list:List<GetLessonCategoriesItem> = emptyList()
        adapter = AdapterLessonCategories(list)
        lesson()
    }


    fun lesson() {
        lessonViewModel.laodi.observe(this, { loading_codes.visible = it })
        lessonViewModel.lessonAll()
        lessonViewModel.lessonsAll.observe(this) { resource ->
            when (resource.status) {
                Status.LOADING -> {
                    lessonViewModel.laodi.postValue(true)
                }
                Status.SUCCESS -> {
                    lessonViewModel.laodi.postValue(false)
                    resource.data?.let {

                    }

                }
                Status.ERROR -> {
                    lessonViewModel.laodi.postValue(false)
                    context?.showMessage(resource.message)
                }
            }
        }

    }


   fun initrecyclerView() {
        recycler_codes.layoutManager = LinearLayoutManager(requireContext())
        recycler_codes.adapter = adapter
        recycler_codes.setHasFixedSize(true)
    }
=======
}

