package ru.kiruxadance.feature_list.domain.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_list.domain.model.Ticker
import ru.kiruxadance.feature_list.domain.repository.TickerRepository
import javax.inject.Inject

class GetTickersUseCase @Inject constructor(
    private val tickerRepository: TickerRepository
){
    operator fun invoke() = flow<Resource<List<Ticker>>> {
        emit(Resource.Loading())
        emit(Resource.Success(tickerRepository.getTickers()))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}