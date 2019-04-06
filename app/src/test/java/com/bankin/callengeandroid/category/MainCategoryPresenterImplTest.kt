package com.bankin.callengeandroid.category

import com.challenge.mob.core.entity.MainCategory
import com.challenge.mob.core.interactor.MainCategoryInteractor
import com.challenge.mob.core.model.CategoriesViewModel
import com.challenge.mob.core.repository.RepositoryException
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.then
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.only
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainCategoryPresenterImplTest {

    @Mock
    private lateinit var view: MainCategoryView

    @InjectMocks
    private lateinit var presenter: MainCategoryPresenterImpl

    @Test
    fun `present should present success`() {
        // Given
        val categories = listOf(
            MainCategory("id1", "name1"),
            MainCategory("id2", "name2")
        )

        val expectedCategoriesViewModel = listOf(
            CategoriesViewModel("id1", "name1"),
            CategoriesViewModel("id2", "name2")
        )

        // When
        presenter.present(
            MainCategoryInteractor.MainCategoryResponse.Success(
                categories
            )
        )

        // Then
        then(view).should(only()).displayCategory(expectedCategoriesViewModel)
    }

    @Test
    fun `present should present failure`() {
        // Given
        val exception = Mockito.mock(RepositoryException::class.java)

        // When
        presenter.present(
            MainCategoryInteractor.MainCategoryResponse.Failure(
                exception
            )
        )

        // Then
        then(view).should(only()).displayError(exception)
    }
}