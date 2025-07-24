package com.example.presentation.usecase.mappers

import com.example.domain.network.data.Players
import com.example.presentation.usecase.uiState.PlayerInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerToPlayerInfoMapper @Inject constructor() {
    operator fun invoke(players: Players): PlayerInfo {
        val uid = players.uid
        val age = players.age
        val name = "${players.personName.firstName} ${players.personName.lastName?:""}"
        val imagerUrl = players.images?.photo?.url?:""
        return PlayerInfo(
            playerUid = uid,
            playerUrl = imagerUrl,
            playerName = name,
            age = age
        )
    }
}