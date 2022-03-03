package com.motion.muslimcollection.ui.mosque.mosques.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.motion.muslimcollection.R
import com.motion.muslimcollection.model.address_model.MosqueItem
import com.motion.muslimcollection.model.vacancy_model.VacancyItem
import com.squareup.picasso.Picasso


class MosqueAdapter(val context: Context):ListAdapter<MosqueItem,MosqueViewHolder>(MosqueItemDiffUtil()) {

    var onMosquesItemClickListener:((MosqueItem)->Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MosqueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_mosque,parent,false)
        return MosqueViewHolder(view)
    }

    override fun onBindViewHolder(holder: MosqueViewHolder, position: Int) {
        val mosqueItem = getItem(position)
        holder.ms_name.text = mosqueItem.name
        holder.ms_address.text = mosqueItem.address
        holder.ms_phone.text = mosqueItem.contacts

        Picasso.get()
            .load(mosqueItem.images)
            .placeholder(R.drawable.ic)
            .error(R.drawable.ic_baseline_image_not)
            .into(holder.s);
        holder.view.setOnClickListener {
            onMosquesItemClickListener?.invoke(mosqueItem)
        }
    }


}