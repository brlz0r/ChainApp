package ru.kiruxadance.chainapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.chainapp.navigation.NavigationProvider
import ru.kiruxadance.feature_list.presentation.navigation.TickerApi

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideNavigationProvider(tickerApi: TickerApi): NavigationProvider{
        return NavigationProvider(tickerApi)
    }
}