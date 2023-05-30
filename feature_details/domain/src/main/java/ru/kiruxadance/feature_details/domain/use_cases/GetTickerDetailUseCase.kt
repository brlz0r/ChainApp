package ru.kiruxadance.feature_details.domain.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_details.domain.model.TickerDetail
import ru.kiruxadance.feature_details.domain.repository.TickerDetailsRepository
import javax.inject.Inject

class GetTickerDetailUseCase @Inject constructor(
    private val tickerDetailsRepository: TickerDetailsRepository
) {
    operator fun invoke(symbol: String) : Flow<Resource<TickerDetail>> = flow {
        emit(Resource.Loading())
        emit(Resource.Success(tickerDetailsRepository.getTickerDetails(symbol)))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}