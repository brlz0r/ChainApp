package ru.kiruxadance.feature_list.data.repository

import ru.kiruxadance.core.network.data_providers.TickersDataProviders
import ru.kiruxadance.feature_list.data.mapper.toDomainTickerList
import ru.kiruxadance.feature_list.domain.model.Ticker
import ru.kiruxadance.feature_list.domain.repository.TickerRepository
import javax.inject.Inject

class TickerRepositoryImpl @Inject constructor(
    private val tickerDataProviders: TickersDataProviders
) : TickerRepository {
    override suspend fun getTickers(): List<Ticker> {
        return tickerDataProviders.getTickers().toDomainTickerList()
    }
}