package ru.kiruxadance.feature_list.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.core.network.data_providers.TickersDataProviders
import ru.kiruxadance.feature_list.data.repository.TickerRepositoryImpl
import ru.kiruxadance.feature_list.domain.repository.TickerRepository

@Module
@InstallIn(SingletonComponent::class)
object DataLayerModule {
    @Provides
    fun provideTickerRepository(tickersDataProviders: TickersDataProviders): TickerRepository {
        return TickerRepositoryImpl(tickersDataProviders)
    }
}