package com.motion.muslimcollection.ui.vacancy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.motion.muslimcollection.R
import com.motion.muslimcollection.model.vacancy_model.VacancyItem

class VacancyAdapter: ListAdapter<VacancyItem, VacancyViewHolder>(VacancyItemDiffUtil()) {

    var onVacancyItemClickListener:((VacancyItem)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vacancy_item,parent,false)
        return VacancyViewHolder(view)
    }
    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
       val vacancyItem = getItem(position)
        holder.textViewNameOfVacancy.text = vacancyItem.name
        holder.textViewSalaryOfVacancy.text = vacancyItem.salary.toString()
        holder.view.setOnClickListener {
            onVacancyItemClickListener?.invoke(vacancyItem)
        }
    }
}