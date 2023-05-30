package ru.kiruxadance.feature_details.data.mappers

import ru.kiruxadance.core.network.model.TickerDto
import ru.kiruxadance.feature_details.domain.model.TickerDetail

fun TickerDto.toDomain(): TickerDetail{
    return TickerDetail(
        last_trade_price = last_trade_price,
        price_24h = price_24h,
        symbol = symbol,
        volume_24h = volume_24h
    )
}