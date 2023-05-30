package ru.kiruxadance.feature_details.presentation.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_details.domain.use_cases.GetTickerDetailUseCase
import javax.inject.Inject

@HiltViewModel
class TickerDetailViewModel @Inject constructor(
    private val getTickerDetailUseCase: GetTickerDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _tickerDetails = mutableStateOf(TickerDetailStateHolder())
    val tickerDetails: State<TickerDetailStateHolder> get() = _tickerDetails

    init {
        savedStateHandle.getLiveData<String>("symbol").observeForever{
            it?.let {
                getTickerDetails(it)
            }
        }
    }

    private fun getTickerDetails(symbol: String) {
        getTickerDetailUseCase(symbol).onEach {
            when(it) {
                is Resource.Error -> {
                    _tickerDetails.value = TickerDetailStateHolder(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _tickerDetails.value = TickerDetailStateHolder(isLoading = true)
                }

                is Resource.Success -> {
                    _tickerDetails.value = TickerDetailStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}