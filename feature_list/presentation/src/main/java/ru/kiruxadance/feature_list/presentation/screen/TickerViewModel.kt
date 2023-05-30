package ru.kiruxadance.feature_list.presentation.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_list.domain.use_cases.GetTickersUseCase
import javax.inject.Inject

@HiltViewModel
class TickerViewModel @Inject constructor(
    private val getTickerUseCase: GetTickersUseCase
) : ViewModel() {

    private val _tickerList = mutableStateOf(TickerStateHolder())
    val tickerList: State<TickerStateHolder> get() = _tickerList

    init {
        viewModelScope.launch {
            getTickerList()
        }
    }

    private fun getTickerList() = viewModelScope.launch {
        getTickerUseCase().onEach {
            when(it) {
                is Resource.Error -> {
                    _tickerList.value = TickerStateHolder(isLoading = true)
                }
                is Resource.Loading -> {
                    _tickerList.value = TickerStateHolder(error = it.message.toString())
                }
                is Resource.Success -> {
                    _tickerList.value = TickerStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}