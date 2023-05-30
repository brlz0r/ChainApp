package ru.kiruxadance.feature_details.data.repository

import ru.kiruxadance.core.network.data_providers.TickersDataProviders
import ru.kiruxadance.feature_details.data.mappers.toDomain
import ru.kiruxadance.feature_details.domain.model.TickerDetail
import ru.kiruxadance.feature_details.domain.repository.TickerDetailsRepository
import javax.inject.Inject

class TickerDetailRepositoryImpl @Inject constructor(
    private val tickersDataProviders: TickersDataProviders
) : TickerDetailsRepository {

    override suspend fun getTickerDetails(symbol: String): TickerDetail {
        return tickersDataProviders.getTickerDetails(symbol).toDomain()
    }
}