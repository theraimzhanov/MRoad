package com.motion.muslimcollection.ui.mosque.mosque_room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.motion.muslimcollection.R
import com.motion.muslimcollection.model.address_model.RoomItem
import com.motion.muslimcollection.ui.mosque.mosque_madrasah.adapter.MadrasahViewHolder
import com.squareup.picasso.Picasso

class RoomAdapter:ListAdapter<RoomItem,RoomViewHolder>(RoomItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_room,parent,false)
        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val madrasahItem = getItem(position)
        holder.rm_name.text = madrasahItem.name
        holder.rm_address.text = madrasahItem.address
        holder.rm_phone.text = madrasahItem.contacts
        Picasso.get()
            .load(madrasahItem.images)
            .placeholder(R.drawable.ic)
            .error(R.drawable.ic_baseline_image_not)
            .into(holder.rm_img);
    }
}