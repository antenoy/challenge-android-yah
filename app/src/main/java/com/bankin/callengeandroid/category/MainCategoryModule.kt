package com.bankin.callengeandroid.category

import com.bankin.callengeandroid.app.FeatureScope
import com.bankin.callengeandroid.app.MainThreadExecutor
import com.nicolasmouchel.executordecorator.ImmutableExecutorDecorator
import com.nicolasmouchel.executordecorator.MutableDecorator
import com.nicolasmouchel.executordecorator.MutableExecutorDecorator
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor

@Module
class MainCategoryModule {

    @MutableExecutorDecorator
    @Provides
    fun provideMainCategoryView(viewDecorator: MutableDecorator<MainCategoryView>): MainCategoryView =
        viewDecorator.asDecorated()

    @FeatureScope
    @Provides
    fun provideMainCategoryViewDecorator(executor: MainThreadExecutor): MutableDecorator<MainCategoryView> =
        MainCategoryViewDecorator(executor)

    @Provides
    @ImmutableExecutorDecorator
    fun provideMainCategoryController(
        executor: Executor,
        mainCategoryControllerImpl: MainCategoryControllerImpl
    ): MainCategoryController = MainCategoryControllerDecorator(
        executor,
        mainCategoryControllerImpl
    )
}
