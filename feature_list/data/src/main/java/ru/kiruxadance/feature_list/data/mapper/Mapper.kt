package ru.kiruxadance.feature_list.data.mapper

import ru.kiruxadance.core.network.model.TickersResponse
import ru.kiruxadance.feature_list.domain.model.Ticker

fun TickersResponse.toDomainTickerList(): List<Ticker> {
    return this.map {
        Ticker(
            last_trade_price = it.last_trade_price,
            price_24h = it.price_24h,
            symbol = it.symbol,
            volume_24h = it.volume_24h)
    }
}