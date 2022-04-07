package com.motion.muslimcollection.ui.eat.restaurant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.motion.muslimcollection.R
import com.motion.muslimcollection.model.cafe_model.FastFoodItem
import com.motion.muslimcollection.model.cafe_model.RestaurantItem
import com.motion.muslimcollection.ui.eat.fastfood.adapter.FastFoodViewHolder
import com.squareup.picasso.Picasso

class RestaurantAdapter(val context: Context):ListAdapter<RestaurantItem,RestaurantViewHolder>(RestaurantItemDiffUtil()) {

    var onItemRestaurantClickListener:((RestaurantItem)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_restaurant,parent,false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = getItem(position)
        holder.nameRestaurant.text = item.name
        holder.locationRestaurant.text = item.address
        holder.phoneRestaurant.text = item.contacts
        if (item.mosqueRoom){
            holder.phoneRestaurant.text = context.getString(R.string.prayer)
        } else{
            holder.prayerRestaurant.text = ""
        }
        Picasso.get().load(item.images).placeholder(R.drawable.image38).into(holder.imageViewRestaurant)
        holder.view.setOnClickListener {
            onItemRestaurantClickListener?.invoke(item)
        }
    }
}