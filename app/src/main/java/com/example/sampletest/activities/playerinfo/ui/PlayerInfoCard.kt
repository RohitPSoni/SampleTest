package com.example.sampletest.activities.playerinfo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sampletest.R
import com.example.sampletest.ui.SampleImage
import com.example.sampletest.ui.SampleText
import com.example.presentation.usecase.uiState.PlayerInfo

@Composable
fun PlayerInfoCard(
    playerInfo: PlayerInfo
) {
    Row(
        modifier = Modifier.padding(16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(color = if (isSystemInDarkTheme().not()) Color(0xFFF3F3F3) else Color(0xFF181818)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SampleImage(
            modifier = Modifier.size(32.dp),
            url = playerInfo.playerUrl,
            fallback = R.mipmap.ic_launcher
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            SampleText(
                charSequence = playerInfo.playerName,
                isBold = true,
                fontColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                fontSize = 14
            )

            SampleText(
                charSequence = playerInfo.playerName,
                fontColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                fontSize = 12
            )
        }
    }
}