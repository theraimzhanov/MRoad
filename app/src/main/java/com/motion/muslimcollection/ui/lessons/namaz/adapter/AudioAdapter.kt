package com.motion.muslimcollection.ui.lessons.namaz.adapter

import android.media.AudioManager
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.ListAdapter
import com.motion.muslimcollection.R
import com.motion.muslimcollection.model.lesson.LessonsItem
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem
import com.motion.muslimcollection.ui.lessons.LessonItemDiffUtil
import com.motion.muslimcollection.ui.lessons.LessonViewHolder
import java.io.IOException

class AudioAdapter: ListAdapter<LessonsItem, AudioViewHolder>(AudioItemDiffUtil()) {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.audiolist,parent,false)
        return AudioViewHolder(view)

    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val lessonItem = getItem(position)
        holder.audioname.text = lessonItem.audio
        holder.button.setOnClickListener {
            mediaPlayer = MediaPlayer()
            mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
            try {
                mediaPlayer!!.setDataSource(lessonItem.audio)
            }catch (e:IOException){
                e.printStackTrace()
            }
            mediaPlayer.start()

        }


    }
}