package com.motion.muslimcollection.ui.eat.fastfood.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R
import com.motion.muslimcollection.model.cafe_model.CafeItem
import com.motion.muslimcollection.model.cafe_model.FastFoodItem
import com.squareup.picasso.Picasso

class FastFoodAdapter(val context: Context): androidx.recyclerview.widget.ListAdapter<FastFoodItem,FastFoodViewHolder>(FastFoodItemDiffUtil()) {

    var onFastFoodItemClickListener:((FastFoodItem)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FastFoodViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.cafe_item,parent,false)
        return FastFoodViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FastFoodViewHolder, position: Int) {
         val item = getItem(position)
        holder.nameFastFood.text ="Фаст-фуд :${item.name}"
        holder.locationFastFood.text = item.address
        holder.phoneFastFood.text = item.contacts
        if (item.mosqueRoom){
            holder.prayerFastFood.text = context.getString(R.string.prayer)
        } else{
            holder.prayerFastFood.text = ""
        }
        Picasso.get().load(item.images).placeholder(R.drawable.image38).into(holder.imageViewFastFood)
        holder.view.setOnClickListener {
            onFastFoodItemClickListener?.invoke(item)
        }

    }

}