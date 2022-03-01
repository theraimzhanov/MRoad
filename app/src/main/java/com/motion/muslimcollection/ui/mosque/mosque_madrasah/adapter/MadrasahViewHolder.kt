package com.motion.muslimcollection.ui.mosque.mosque_madrasah.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class MadrasahViewHolder(val view: View): RecyclerView.ViewHolder(view){
    val md_name : TextView = view.findViewById(R.id.madrasah_name)
    val md_address : TextView = view.findViewById(R.id.madrasah_address)
    val md_phone : TextView = view.findViewById(R.id.madrasah_phone)
    val md_img : ImageView = view.findViewById(R.id.img_madrasah)

}
