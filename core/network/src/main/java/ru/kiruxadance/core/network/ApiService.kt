package ru.kiruxadance.core.network

import retrofit2.http.GET
import ru.kiruxadance.core.network.model.TickersResponse

interface ApiService {

    @GET("exchange/tickers")
    suspend fun getTickers(): TickersResponse
}