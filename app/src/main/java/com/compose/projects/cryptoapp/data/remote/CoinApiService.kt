package com.compose.projects.cryptoapp.data.remote

import com.editor.crypto.data.remote.dto.CoinDetailDto
import com.editor.crypto.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApiService {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinID}")
    suspend fun getCoinByID(@Path("coinID") coinID: String) : CoinDetailDto
}