package ru.kiruxadance.feature_details.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.feature_details.domain.repository.TickerDetailsRepository
import ru.kiruxadance.feature_details.domain.use_cases.GetTickerDetailUseCase

@Module
@InstallIn(SingletonComponent::class)
object DomainLayerModule {

    @Provides
    fun provideGetTickerDetailUseCase(tickerDetailsRepository: TickerDetailsRepository) : GetTickerDetailUseCase {
        return GetTickerDetailUseCase(tickerDetailsRepository)
    }
}