package ru.kiruxadance.feature_list.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.feature_list.presentation.navigation.TickerApi
import ru.kiruxadance.feature_list.presentation.navigation.TickerApiImpl

@Module
@InstallIn(SingletonComponent::class)
class UIModule {

    @Provides
    fun provideTickerApi(): TickerApi {
        return TickerApiImpl()
    }

}