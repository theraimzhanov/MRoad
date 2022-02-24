package com.motion.muslimcollection.ui.vacancy.adapter

import androidx.recyclerview.widget.DiffUtil
import com.motion.muslimcollection.model.vacancy_model.VacancyItem

class VacancyItemDiffUtil: DiffUtil.ItemCallback<VacancyItem>() {

    override fun areItemsTheSame(oldItem: VacancyItem, newItem: VacancyItem): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: VacancyItem, newItem: VacancyItem): Boolean {
         return oldItem == newItem
    }
}