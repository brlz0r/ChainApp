package ru.kiruxadance.feature_list.domain.repository

import ru.kiruxadance.feature_list.domain.model.Ticker

interface TickerRepository {
    suspend fun getTickers(): List<Ticker>
}