package com.example.presentation.usecase

import com.example.domain.network.data.WebSocketEvent
import com.example.domain.network.repositiry.WebSocketRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SubscribeToWebsocketUseCase @Inject constructor(
    private val webSocketRepository: WebSocketRepository
){
    private val serverMessages = MutableStateFlow("")
    init {
        webSocketRepository.connect("wss://echo.websocket.org")
            .onEach {
                if (it is WebSocketEvent.OnMessage) {
                    serverMessages.emit(it.message)
                } else if (it is WebSocketEvent.OnFailure) {
                    serverMessages.emit(it.th.message ?: "Connection closed")
                }
            }
    }
    operator fun invoke() = serverMessages
}