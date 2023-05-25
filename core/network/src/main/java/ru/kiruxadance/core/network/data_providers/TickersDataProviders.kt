package ru.kiruxadance.core.network.data_providers

import ru.kiruxadance.core.network.ApiService
import javax.inject.Inject

class TickersDataProviders @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getTickers() = apiService.getTickers()
}