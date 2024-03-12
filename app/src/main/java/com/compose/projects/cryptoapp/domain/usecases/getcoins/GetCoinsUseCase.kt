package com.compose.projects.cryptoapp.domain.usecases.getcoins

import com.compose.projects.cryptoapp.common.Resource
import com.editor.crypto.data.remote.dto.toCoin
import com.compose.projects.cryptoapp.domain.model.Coin
import com.compose.projects.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { coinDto -> coinDto.toCoin() }
            //Forward to UI
            emit(Resource.Success(coins))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}