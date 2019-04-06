package com.challenge.mob.core.interactor

import com.challenge.mob.core.entity.MainCategory
import com.challenge.mob.core.presenter.MainCategoryPresenter
import com.challenge.mob.core.repository.MainCategoryRepository
import com.challenge.mob.core.repository.RepositoryException
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.only
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainCategoryInteractorTest {

    @Mock
    private lateinit var repository: MainCategoryRepository

    @Mock
    private lateinit var presenter: MainCategoryPresenter

    @InjectMocks
    private lateinit var interactor: MainCategoryInteractor

    @Test
    fun `loadCategory should present success`() {
        // Given
        val categories = listOf(
            MainCategory("id1", "name1"),
            MainCategory("id2", "name2")
        )
        given(repository.loadCategory()).willReturn(categories)

        // When
        interactor.loadCategory()

        // Then
        then(presenter).should(only()).present(
            MainCategoryInteractor.MainCategoryResponse.Success(
                categories
            )
        )
    }

    @Test
    fun `loadCategory should present failure`() {
        // Given
        val exception = mock(RepositoryException::class.java)
        given(repository.loadCategory()).willThrow(exception)

        // When
        interactor.loadCategory()

        // Then
        then(presenter).should(only()).present(
            MainCategoryInteractor.MainCategoryResponse.Failure(exception)
        )
    }
}