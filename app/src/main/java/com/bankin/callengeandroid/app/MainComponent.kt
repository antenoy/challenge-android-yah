package com.bankin.callengeandroid.app

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class, NetworkModule::class])
interface MainComponent {


}