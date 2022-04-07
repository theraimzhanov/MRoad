package com.motion.muslimcollection.ui.mosque.mosque_university.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.motion.muslimcollection.R
import com.motion.muslimcollection.model.address_model.UniversityItem
import com.squareup.picasso.Picasso

class AdapterUniversities: androidx.recyclerview.widget.ListAdapter<UniversityItem, UniversityViewHolder>(UniversityItemDiffUtil()) {
    var onUniversityItemClickListener:((UniversityItem)->Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_university,parent,false)
        return UniversityViewHolder(view)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val madrasahItem = getItem(position)
        holder.un_name.text = madrasahItem.name
        holder.un_address.text = madrasahItem.address
        holder.un_phone.text = madrasahItem.contacts
        Picasso.get()
            .load(madrasahItem.images)
            .placeholder(R.drawable.ic)
            .error(R.drawable.ic_baseline_image_not)
            .into(holder.un_img);

        holder.view.setOnClickListener {
            onUniversityItemClickListener?.invoke(madrasahItem)
        }
    }
}





