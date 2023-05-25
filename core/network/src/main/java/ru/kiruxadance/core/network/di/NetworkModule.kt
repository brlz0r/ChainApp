package ru.kiruxadance.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.kiruxadance.core.network.ApiService
import ru.kiruxadance.core.network.data_providers.TickersDataProviders

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl("https://api.blockchain.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideTickerDataProvider(apiService: ApiService): TickersDataProviders {
        return TickersDataProviders(apiService)
    }
}