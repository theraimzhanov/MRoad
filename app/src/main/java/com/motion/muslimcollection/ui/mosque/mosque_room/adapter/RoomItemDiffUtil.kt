package com.motion.muslimcollection.ui.mosque.mosque_room.adapter

import androidx.recyclerview.widget.DiffUtil
import com.motion.muslimcollection.model.address_model.RoomItem

class RoomItemDiffUtil:DiffUtil.ItemCallback<RoomItem>() {
    override fun areItemsTheSame(oldItem: RoomItem, newItem: RoomItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RoomItem, newItem: RoomItem): Boolean {
       return oldItem == newItem
    }
}