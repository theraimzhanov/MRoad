package com.motion.muslimcollection.ui.eat.cafe.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class CafeViewHolder(val view: View): RecyclerView.ViewHolder(view) {
   val nameCafe:TextView = view.findViewById(R.id.cf_name)
   val prayerCafe:TextView = view.findViewById(R.id.cafe_ms_room_yes)
   val phoneCafe:TextView = view.findViewById(R.id.cf_phone)
   val locationCafe:TextView = view.findViewById(R.id.cf_address)
    val imageViewCafe:ImageView = view.findViewById(R.id.img_cafe)
}