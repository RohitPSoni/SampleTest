package com.example.presentation.usecase

import com.example.domain.network.repositiry.WebSocketRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SendMessageUseCase @Inject constructor(
    private val webSocketRepository: WebSocketRepository
){
    operator fun invoke(message: String) {
        webSocketRepository.sendMessage(message)
    }
}