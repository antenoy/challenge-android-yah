package com.challenge.mob.repository.maincategory

import com.challenge.mob.core.entity.MainCategory
import com.challenge.mob.core.repository.MainCategoryRepository
import com.challenge.mob.repository.ChallengeServices
import java.io.IOException

class MainCategoryRepositoryImpl(
    private val challengeServices: ChallengeServices
) : MainCategoryRepository {

    override fun loadCategory(): List<MainCategory> {
        try {
            val response = challengeServices.getCategory().execute()
            val jsonResources = response.body() ?: throw MainCategoryRepository.Failure()
            return transformToEntity(jsonResources)
        } catch (e: IOException) {
            throw MainCategoryRepository.Failure()
        }
    }

    private fun transformToEntity(jsonResources: JsonRessources): List<MainCategory> =
        jsonResources.resources
            .filter { it.parent == null }
            .map { jsonMainCategory ->
                MainCategory(
                    jsonMainCategory.id,
                    jsonMainCategory.name
                )
            }
}