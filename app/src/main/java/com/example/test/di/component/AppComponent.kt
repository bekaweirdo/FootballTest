package com.example.test.di.component

import android.content.Context
import com.example.test.MainActivity
import com.example.test.di.module.AppModule
import com.example.test.ui.matches.MatchesFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(matchesFragment: MatchesFragment)
}