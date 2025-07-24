package com.example.presentation.usecase

import com.example.domain.network.repositiry.ApiRepository
import com.example.presentation.usecase.mappers.PlayerToPlayerInfoMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPlayersDataUseCase @Inject constructor(
    private val mapper: PlayerToPlayerInfoMapper,
    private val repository: ApiRepository
){
    suspend operator fun invoke() =
        repository.loadAllData().players.map {
            mapper(it)
        }
}