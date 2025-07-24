package com.example.domain.network.di

import com.example.domain.network.repositiry.ApiRepository
import com.example.domain.network.repositiry.ApiRepositoryImpl
import com.example.domain.network.repositiry.WebSocketRepository
import com.example.domain.network.repositiry.WebSocketRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    abstract fun bindWebSocketRepository(impl: WebSocketRepositoryImpl): WebSocketRepository

    @Binds
    abstract fun bindApiRepository(impl: ApiRepositoryImpl): ApiRepository
}
