package ru.kiruxadance.feature_details.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.feature_details.presentation.navigation.TickerDetailApi
import ru.kiruxadance.feature_details.presentation.navigation.TickerDetailsApiImpl

@Module
@InstallIn(SingletonComponent::class)
object UIModule {

    @Provides
    fun provideTickerDetailApi(): TickerDetailApi {
        return TickerDetailsApiImpl()
    }
}