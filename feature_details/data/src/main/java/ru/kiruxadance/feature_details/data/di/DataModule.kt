package ru.kiruxadance.feature_details.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.core.network.data_providers.TickersDataProviders
import ru.kiruxadance.feature_details.data.repository.TickerDetailRepositoryImpl
import ru.kiruxadance.feature_details.domain.repository.TickerDetailsRepository

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideTickerDetailRepository(tickersDataProviders: TickersDataProviders): TickerDetailsRepository {
        return TickerDetailRepositoryImpl(tickersDataProviders)
    }
}