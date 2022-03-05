package com.motion.muslimcollection.ui.eat.cafe.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.motion.muslimcollection.R
import com.motion.muslimcollection.ext.loadImage
import com.motion.muslimcollection.model.cafe_model.CafeItem
import com.motion.muslimcollection.model.vacancy_model.VacancyItem
import com.squareup.picasso.Picasso

class CafeAdapter(val context: Context): ListAdapter<CafeItem,CafeViewHolder>(CafeItemDiffUtil()) {

    var onCafeItemClickListener:((CafeItem)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cafe_item,parent,false)
        return CafeViewHolder(view)
    }

    @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
    override fun onBindViewHolder(holder: CafeViewHolder, position: Int) {
        val item = getItem(position)
        holder.nameCafe.text ="Кафе :${item.name}"
        holder.locationCafe.text = item.address
        holder.phoneCafe.text = item.contacts
        if (item.mosqueRoom){
            holder.prayerCafe.text = context.getString(R.string.prayer)
        } else{
            holder.prayerCafe.text = ""
        }
        Picasso.get().load(item.images).placeholder(R.drawable.image38).into(holder.imageViewCafe)
        holder.view.setOnClickListener {
            onCafeItemClickListener?.invoke(item)
        }
    }

}