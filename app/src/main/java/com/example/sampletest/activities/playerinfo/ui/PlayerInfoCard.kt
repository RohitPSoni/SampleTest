package com.example.sampletest.activities.playerinfo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.sampletest.R
import com.example.common_ui.SampleImage
import com.example.common_ui.SampleText
import com.example.common_ui.primary
import com.example.common_ui.secondary
import com.example.presentation.usecase.uiState.PlayerInfo

@Composable
fun PlayerInfoCard(
    playerInfo: PlayerInfo
) {
    Row(
        modifier = Modifier.padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = secondary),
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
                fontColor = primary,
                fontSize = 14
            )

            SampleText(
                charSequence = playerInfo.playerName,
                fontColor = primary,
                fontSize = 12
            )
        }
    }
}