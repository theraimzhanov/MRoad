package com.motion.muslimcollection.model.vacancies

data class VacancyItem(
    val name: String,
    val company: String,
    val requirements: String,
    val duties:String,
    val conditions:String,
    val id: Int = ID_NO_IMPORTANT,
    val salary: Int = PRICE_SALARY
){
    companion object{
        const val ID_NO_IMPORTANT = -1
        const val PRICE_SALARY = 0
    }
}