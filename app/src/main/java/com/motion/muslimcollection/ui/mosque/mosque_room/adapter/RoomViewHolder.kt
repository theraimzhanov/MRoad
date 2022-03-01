package com.motion.muslimcollection.ui.mosque.mosque_room.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class RoomViewHolder(val view: View): RecyclerView.ViewHolder(view){
    val rm_name : TextView = view.findViewById(R.id.rm_name)
    val rm_address : TextView = view.findViewById(R.id.rm_address)
    val rm_phone : TextView = view.findViewById(R.id.rm_phone)
    val rm_img : ImageView = view.findViewById(R.id.img_room)

}