package ru.kiruxadance.feature_details.domain.repository

import ru.kiruxadance.feature_details.domain.model.TickerDetail

interface TickerDetailsRepository {
    suspend fun getTickerDetails(symbol: String) : TickerDetail
}