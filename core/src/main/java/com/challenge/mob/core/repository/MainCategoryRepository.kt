package com.challenge.mob.core.repository

import com.challenge.mob.core.entity.MainCategory

interface MainCategoryRepository {

    @Throws(Failure::class)
    fun loadCategory() : List<MainCategory>

    class Failure : Exception()
}