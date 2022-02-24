package com.motion.muslimcollection.ui.eat.cafe.adapter

import androidx.recyclerview.widget.DiffUtil
import com.motion.muslimcollection.model.cafe_model.CafeItem

class CafeItemDiffUtil: DiffUtil.ItemCallback<CafeItem>() {

    override fun areItemsTheSame(oldItem: CafeItem, newItem: CafeItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CafeItem, newItem: CafeItem): Boolean {
        return oldItem == newItem
    }
}