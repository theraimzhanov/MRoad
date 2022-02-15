package com.motion.muslimcollection.ui.lessons



import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.activity.OnBackPressedCallback

import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.di.viewModules
import com.motion.muslimcollection.ext.ItemClickListener
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.lessons.namaz.NamazFragment
import com.motion.muslimcollection.ui.lessons.namaz.NamazFragmentDirections
import com.motion.muslimcollection.ui.main.MainActivity
import com.motion.muslimcollection.ui.mechet.screenmechet.addmechet.AddMechetFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_lessons.*
import org.koin.android.ext.android.inject


class LessonsFragment : BaseFragment(R.layout.fragment_lessons) {
    private val lessonViewModel: LessonViewModel by inject()
    private val adapter:AdapterLessonCategories by lazy {
        AdapterLessonCategories()
    }
    override fun setupObservers() {
    }
    override fun showConnectedState() {
        lessonCategories()
        adapter.setItemClickListener(object : ItemClickListener {
            override fun onItemClick(position: Int) {
                val id = position
                val action = LessonsFragmentDirections.actionLessonsFragmentToNamazFragment(id)
                (activity as MainActivity).navController.navigate(action)
                Log.d("TAG", "onItemClick:$id ")
            }

        })


    override fun saveOnBoard(b: Boolean) {

    }
    private fun closeScreen(){
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                (activity as MainActivity).navController.navigate(R.id.action_lessonsFragment_to_homeFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback)
//closeScreen()//setupUI()
    }
    override fun saveOnBoard(b: Boolean) {

    }
    override fun setupUI() {
        super.setupUI()

        closeScreen()



    }
    override fun showBottomNavigation() {
        super.showBottomNavigation()

    }
    fun lessonCategories() {
        lessonViewModel.load.observe(this,{loading_codes.visible = it})
        lessonViewModel.getLessCategorId.observe(this) { resources ->
            resources.data?.let {
                adapter.setList(resources.)
            }
            when (resources.status) {
                Status.LOADING -> {
                    lessonViewModel.load.postValue(true)
                }
                Status.SUCCESS -> {
                    lessonViewModel.load.postValue(false)
                    resources.data?.let {
                       if (it!!.isNotEmpty()){
                           adapter.setList(resources.data)
                       }
                        initrecyclerView()
                    }
                }
                Status.ERROR->{
                     lessonViewModel.load.postValue(false)
                    context?.showMessage(resources.message)
                }
            }
        }
    }
    fun   initrecyclerView(){
        recycler_codes.layoutManager = LinearLayoutManager(context)
        recycler_codes.adapter = adapter
    }
}

