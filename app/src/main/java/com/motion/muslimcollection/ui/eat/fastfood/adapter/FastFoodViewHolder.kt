package com.motion.muslimcollection.ui.eat.fastfood.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class FastFoodViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val nameFastFood: TextView = view.findViewById(R.id.ff_name)
    val prayerFastFood: TextView = view.findViewById(R.id.ff_work_time)
    val phoneFastFood: TextView = view.findViewById(R.id.ff_phone)
    val locationFastFood: TextView = view.findViewById(R.id.ff_address)
    val imageViewFastFood: ImageView = view.findViewById(R.id.img_fast_food)
}