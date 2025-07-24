package com.example.sampletest.activities.websocket

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

data class WebSocketState(
    val messageFromServer: SnapshotStateList<String> = mutableStateListOf(),
)

class WebSocketEffect