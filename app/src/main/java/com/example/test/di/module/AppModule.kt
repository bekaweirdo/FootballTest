package com.example.test.di.module

import com.example.test.data.network.StadiumService
import com.example.test.repository.DataRepository
import com.example.test.ui.StadiumViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideStadiumViewModelFactory(
        dataRepository: DataRepository
    ): StadiumViewModelFactory = StadiumViewModelFactory(dataRepository)

    @Provides
    @Singleton
    fun provideDataRepository(
        stadiumService: StadiumService
    ): DataRepository = DataRepository(stadiumService)

    @Provides
    @Singleton
    fun provideStadiumService(): StadiumService = StadiumService.create()
}