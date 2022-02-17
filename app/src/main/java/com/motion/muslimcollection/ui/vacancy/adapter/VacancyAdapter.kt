package com.motion.muslimcollection.ui.vacancy.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R
import com.motion.muslimcollection.model.vacancies.VacancyItem

class VacancyAdapter: ListAdapter<VacancyItem, VacancyViewHolder>(VacancyItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vacancy_item,parent,false)
        return VacancyViewHolder(view)
    }
    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
       val vacancyItem = getItem(position)
        holder.textViewNameOfVacancy.text = vacancyItem.name
        holder.textViewSalaryOfVacancy.text = vacancyItem.salary.toString()
    }
}