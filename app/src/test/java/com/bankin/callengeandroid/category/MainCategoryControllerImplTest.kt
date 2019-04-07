package com.bankin.callengeandroid.category

import com.challenge.mob.core.interactor.MainCategoryInteractor
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.then
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.only
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainCategoryControllerImplTest {

    @Mock
    private lateinit var interactor: MainCategoryInteractor

    @InjectMocks
    private lateinit var controller: MainCategoryControllerImpl

    @Test
    fun loadCategory() {
        // Given
        // When
        controller.loadCategory()

        // Then
        then(interactor).should(only()).loadCategory()
    }
}