package com.bankin.callengeandroid.subcategory

import com.challenge.mob.core.entity.SubCategory
import com.challenge.mob.core.interactor.SubCategoryInteractor
import com.challenge.mob.core.model.SubCategoriesViewModel
import com.challenge.mob.core.repository.RepositoryException
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.then
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.only
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SubCategoryPresenterImplTest {

    @Mock
    private lateinit var view: SubCategoryView

    @InjectMocks
    private lateinit var presenter: SubCategoryPresenterImpl

    @Test
    fun `present should call displaySubCategories with Success`() {
        // Given
        val subCategories = listOf(
            SubCategory("name1"),
            SubCategory("name2")
        )

        val subCategoriesViewModel = listOf(
            SubCategoriesViewModel("name1"),
            SubCategoriesViewModel("name2")
        )

        // When
        presenter.present(
            SubCategoryInteractor.SubCategoryResponse.Success(subCategories)
        )

        // Then
        then(view).should(only())
            .displaySubCategories(
                subCategoriesViewModel
            )
    }

    @Test
    fun `present should call displayError with Exception`() {
        // Given
        val exception = mock(RepositoryException::class.java)

        // When
        presenter.present(
            SubCategoryInteractor.SubCategoryResponse.Failure(exception)
        )

        // Then
        then(view).should(only()).displayError(exception)
    }
}