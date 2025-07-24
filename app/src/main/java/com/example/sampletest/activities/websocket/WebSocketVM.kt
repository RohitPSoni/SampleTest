package com.example.sampletest.activities.websocket

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.viewModelScope
import com.example.presentation.usecase.SendMessageUseCase
import com.example.presentation.usecase.SubscribeToWebsocketUseCase
import com.example.sampletest.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WebSocketVM @Inject constructor(
    private val subscribeToWebsocketUseCase: SubscribeToWebsocketUseCase,
    private val sendMessageUseCase: SendMessageUseCase
): BaseViewModel<WebSocketState, WebSocketEffect>(){

    private var count = 0
    init {
        viewState = WebSocketState()
        subscribeToWebsocket()
    }

    fun sendMessage(message: String) {
        count ++
        sendMessageUseCase("$message $count")
    }

    private fun subscribeToWebsocket() {
        val serverMessages = mutableStateListOf<String>()
        viewState = viewState.copy(messageFromServer = serverMessages)
        viewModelScope.launch {
            subscribeToWebsocketUseCase().collect {
                serverMessages.add(it)
            }
        }
    }
}