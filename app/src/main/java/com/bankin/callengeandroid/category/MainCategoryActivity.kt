package com.bankin.callengeandroid.category

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bankin.callengeandroid.R
import com.bankin.callengeandroid.app.ChallengeApplication
import com.challenge.mob.core.model.CategoriesViewModel
import com.nicolasmouchel.executordecorator.MutableDecorator
import javax.inject.Inject

class MainCategoryActivity : AppCompatActivity(), MainCategoryView {

    @Inject
    lateinit var viewDecorator: MutableDecorator<MainCategoryView>

    @Inject
    lateinit var controller: MainCategoryController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_category)

        ChallengeApplication.getComponent(this)
            .plus(MainCategoryModule())
            .inject(this)

        viewDecorator.mutate(this)
        controller.loadCategory()
    }

    override fun onDestroy() {
        viewDecorator.mutate(null)
        super.onDestroy()
    }

    override fun displayCategory(categories: List<CategoriesViewModel>) {
        //TODO Adapter Here
    }

    override fun displayError(exception: Throwable) {
        //TODO AlertDialog Here
    }
}
