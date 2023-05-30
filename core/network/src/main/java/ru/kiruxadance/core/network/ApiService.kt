package ru.kiruxadance.core.network

import retrofit2.http.GET
import retrofit2.http.Path
import ru.kiruxadance.core.network.model.TickerDto
import ru.kiruxadance.core.network.model.TickersResponse

interface ApiService {

    @GET("exchange/tickers")
    suspend fun getTickers(): TickersResponse

    @GET("exchange/tickers/{symbol}")
    suspend fun getTickerDetail(@Path("symbol") symbol: String) : TickerDto
}