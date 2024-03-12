package com.compose.projects.cryptoapp.di

import com.compose.projects.cryptoapp.common.Constants
import com.compose.projects.cryptoapp.data.remote.CoinApiService
import com.compose.projects.cryptoapp.data.repository.CoinRepositoryImpl
import com.compose.projects.cryptoapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideCoinApiService(): CoinApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApiService): CoinRepository = CoinRepositoryImpl(api)


}