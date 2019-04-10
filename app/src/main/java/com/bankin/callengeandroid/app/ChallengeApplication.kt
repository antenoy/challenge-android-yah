package com.bankin.callengeandroid.app

import android.app.Application
import android.content.Context
import com.orhanobut.hawk.Hawk
import timber.log.Timber

class ChallengeApplication : Application() {
    private lateinit var component: MainComponent

    companion object {
        fun getComponent(context: Context): MainComponent {
            val application = context.applicationContext as ChallengeApplication
            return application.component
        }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Hawk.init(this).build()
        component = DaggerMainComponent.builder().mainModule(MainModule(this)).build()
    }
}