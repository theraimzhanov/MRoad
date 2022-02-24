package com.motion.muslimcollection.ui.eat.magazine.adapter

import androidx.recyclerview.widget.DiffUtil
import com.motion.muslimcollection.model.cafe_model.MagazineItem

class MagazineItemDiffUtil: DiffUtil.ItemCallback<MagazineItem>() {
    override fun areItemsTheSame(oldItem: MagazineItem, newItem: MagazineItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MagazineItem, newItem: MagazineItem): Boolean {
        return oldItem == newItem
    }
}