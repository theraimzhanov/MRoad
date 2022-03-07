package com.motion.muslimcollection.ui.eat.magazine.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.motion.muslimcollection.R
import com.motion.muslimcollection.model.cafe_model.MagazineItem
import com.motion.muslimcollection.model.vacancy_model.VacancyItem
import com.squareup.picasso.Picasso

class MagazineAdapter:ListAdapter<MagazineItem,MagazineViewHolder>(MagazineItemDiffUtil()) {

 var onMagazineItemClickListener:((MagazineItem)->Unit)? = null

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MagazineViewHolder {
 val view = LayoutInflater.from(parent.context).inflate(R.layout.magazine_item,parent,false)
  return MagazineViewHolder(view)
 }

 override fun onBindViewHolder(holder: MagazineViewHolder, position: Int) {
  val item = getItem(position)
  holder.nameOfMagazine.text = item.name
  holder.timeOfMagazine.text = item.site
  holder.phoneOfMagazine.text = item.contacts
  holder.locationMagazine.text = item.address
  Picasso.get().load(item.images).into(holder.imageViewOfMagazine)
  holder.view.setOnClickListener {
   onMagazineItemClickListener?.invoke(item)
  }
 }
}