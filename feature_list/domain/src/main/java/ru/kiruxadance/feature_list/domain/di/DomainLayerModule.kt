package ru.kiruxadance.feature_list.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.feature_list.domain.repository.TickerRepository
import ru.kiruxadance.feature_list.domain.use_cases.GetTickersUseCase

@Module
@InstallIn(SingletonComponent::class)
object DomainLayerModule {

    @Provides
    fun provideGetTickersUseCase(tickerRepository: TickerRepository): GetTickersUseCase {
        return GetTickersUseCase(tickerRepository)
    }
}