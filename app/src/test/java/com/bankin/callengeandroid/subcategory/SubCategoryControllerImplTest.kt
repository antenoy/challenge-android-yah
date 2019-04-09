package com.bankin.callengeandroid.subcategory

import com.challenge.mob.core.interactor.SubCategoryInteractor
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.then
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.only
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SubCategoryControllerImplTest {

    @Mock
    private lateinit var interactor: SubCategoryInteractor

    @InjectMocks
    private lateinit var controller: SubCategoryControllerImpl

    @Test
    fun loadSubCategories() {
        // Given
        val mainCategoryId = "mainCategoryId"

        // When
        controller.loadSubCategories(mainCategoryId)

        // Then
        then(interactor).should(only()).loadSubCategories(mainCategoryId)
    }
}