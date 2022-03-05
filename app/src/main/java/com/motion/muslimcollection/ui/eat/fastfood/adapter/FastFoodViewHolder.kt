package com.motion.muslimcollection.ui.eat.fastfood.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class FastFoodViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val nameFastFood: TextView = view.findViewById(R.id.nameOfCafe)
    val prayerFastFood: TextView = view.findViewById(R.id.prayerCafe)
    val phoneFastFood: TextView = view.findViewById(R.id.phoneOfCafe)
    val locationFastFood: TextView = view.findViewById(R.id.locationCafe)
    val imageViewFastFood: ImageView = view.findViewById(R.id.imageViewCafe)
}