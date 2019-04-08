package com.bankin.callengeandroid.subcategory

import com.bankin.callengeandroid.app.FeatureScope
import com.bankin.callengeandroid.app.MainThreadExecutor
import com.challenge.mob.core.presenter.SubCategoryPresenter
import com.nicolasmouchel.executordecorator.ImmutableExecutorDecorator
import com.nicolasmouchel.executordecorator.MutableDecorator
import com.nicolasmouchel.executordecorator.MutableExecutorDecorator
import dagger.Binds
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor

@Module(includes = [SubCategoryBinderModule::class])
class SubCategoryModule {

    @MutableExecutorDecorator
    @Provides
    fun provideSubCategoryView(viewDecorator: MutableDecorator<SubCategoryView>): SubCategoryView =
        viewDecorator.asDecorated()

    @FeatureScope
    @Provides
    fun provideSubCategoryViewDecorator(executor: MainThreadExecutor): MutableDecorator<SubCategoryView> =
        SubCategoryViewDecorator(executor)

    @Provides
    @ImmutableExecutorDecorator
    fun provideSubCategoryController(
        executor: Executor,
        subCategoryControllerImpl: SubCategoryControllerImpl
    ): SubCategoryController = SubCategoryControllerDecorator(
        executor,
        subCategoryControllerImpl
    )

}

@Module
abstract class SubCategoryBinderModule {
    @Binds
    abstract fun bindSubCategoryPresenter(implementation: SubCategoryPresenterImpl): SubCategoryPresenter
}