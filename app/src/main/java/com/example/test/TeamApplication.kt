package com.example.test

import android.app.Application
import com.example.test.di.component.AppComponent
import com.example.test.di.component.DaggerAppComponent

class TeamApplication: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}