package com.motion.muslimcollection.ui.mosque.mosque_madrasah.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.motion.muslimcollection.R
import com.motion.muslimcollection.model.address_model.MadrasahItem
import com.motion.muslimcollection.model.vacancy_model.VacancyItem
import com.motion.muslimcollection.ui.mosque.mosques.adapter.MosqueViewHolder
import com.squareup.picasso.Picasso

class MadrasahAdapter:ListAdapter<MadrasahItem,MadrasahViewHolder>(MadrasahItemDiffUtil()) {
    var onMadrasahItemClickListener:((MadrasahItem)->Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MadrasahViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_madrasah,parent,false)
        return MadrasahViewHolder(view)
    }

    override fun onBindViewHolder(holder: MadrasahViewHolder, position: Int) {
        val madrasahItem = getItem(position)
        holder.md_name.text = madrasahItem.name
        holder.md_address.text = madrasahItem.address
        holder.md_phone.text = madrasahItem.contacts
        Picasso.get()
            .load(madrasahItem.images)
            .placeholder(R.drawable.ic)
            .error(R.drawable.ic_baseline_image_not)
            .into(holder.md_img)
        holder.view.setOnClickListener {
            onMadrasahItemClickListener?.invoke(madrasahItem)
        }


    }
}