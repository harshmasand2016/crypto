package com.compose.projects.cryptoapp.domain.usecases.getcoin

import com.compose.projects.cryptoapp.common.Resource
import com.editor.crypto.data.remote.dto.toCoinDetail
import com.compose.projects.cryptoapp.domain.model.CoinDetail
import com.compose.projects.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinID: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinByID(coinID).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}