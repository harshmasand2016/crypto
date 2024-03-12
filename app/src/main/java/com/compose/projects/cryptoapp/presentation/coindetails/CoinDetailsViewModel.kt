package com.compose.projects.cryptoapp.presentation.coindetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.projects.cryptoapp.common.Constants
import com.compose.projects.cryptoapp.common.Resource
import com.compose.projects.cryptoapp.domain.usecases.getcoin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinID ->
            getCoinByID(coinID)
        }
    }


    private fun getCoinByID(coinID: String) {
        getCoinUseCase(coinID).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CoinDetailsState(coin = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        CoinDetailsState(error = result.message ?: "Something went wrong")
                }

                else -> {}
            }
        }.launchIn(viewModelScope)
    }
}