package com.motion.muslimcollection.ui.eat.cafe.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class CafeViewHolder(val view: View): RecyclerView.ViewHolder(view) {
   val nameCafe:TextView = view.findViewById(R.id.nameOfCafe)
   val prayerCafe:TextView = view.findViewById(R.id.prayerCafe)
   val phoneCafe:TextView = view.findViewById(R.id.phoneOfCafe)
   val locationCafe:TextView = view.findViewById(R.id.locationCafe)
    val imageViewCafe:ImageView = view.findViewById(R.id.imageViewCafe)
}