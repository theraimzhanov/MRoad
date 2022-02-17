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
    override fun setupObservers() {

    }

    override fun showConnectedState() {

    }

    override fun saveOnBoard(b: Boolean) {
    }

}

