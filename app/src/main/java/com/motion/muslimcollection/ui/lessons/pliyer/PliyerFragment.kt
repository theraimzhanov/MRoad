package com.motion.muslimcollection.ui.lessons.pliyer

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ext.visible
import com.motion.muslimcollection.network.result.Status
import com.motion.muslimcollection.ui.lessons.LessonViewModel
import com.motion.muslimcollection.ui.lessons.namaz.NamazFragmentArgs
import kotlinx.android.synthetic.main.fragment_namaz.*
import kotlinx.android.synthetic.main.fragment_pliyer.*
import org.koin.android.ext.android.inject

class PliyerFragment : BaseFragment(R.layout.fragment_pliyer) {
    private val lessonViewModel: LessonViewModel by inject()
    val args: PliyerFragmentArgs by navArgs()
    override fun setupObservers() {

    }

    override fun showConnectedState() {
        initData(args.audio)
    }
    override fun saveOnBoard(b: Boolean) {
    }
    private fun initData(id: Int) {
        lessonViewModel.laodi.observe(this) { loading_audio.visible = it }
        lessonViewModel.getAudioId(id)
        lessonViewModel.audioId.observe(this){ it ->
            when(it.status){
                Status.LOADING -> {
                    lessonViewModel.laodi.postValue(true)
                }
                Status.SUCCESS -> {
                    lessonViewModel.laodi.postValue(false)

                    audio.text = it.data?.audio
                    var  a =it.data?.audio

                    play.setOnClickListener {
                        val url = a // your URL here
                        val mediaPlayer = MediaPlayer().apply {
                            setAudioAttributes(
                                AudioAttributes.Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build()
                            )
                            setDataSource(url)
                            prepare() // might take long! (for buffering, etc)
                            start()
                        }
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