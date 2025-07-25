package com.example.sampletest.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Sample button for this app with bordered area
 * @param modifier [Modifier]
 * @param charSequence annotated or plain text
 * @param onClick callback when button is clicked
 */
@Composable
fun SampleButton(
    modifier: Modifier = Modifier,
    charSequence: CharSequence,
    onClick: () -> Unit
) {
    SampleText(
        modifier = modifier.clip(RoundedCornerShape(8.dp))
            .border(width = 1.dp, color = Color.Blue, RoundedCornerShape(8.dp))
            .clickable {
                onClick.invoke()
            }
            .padding(vertical = 4.dp, horizontal = 8.dp),
        charSequence = charSequence,
        fontColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
        fontSize = 14
    )
}

@CombineThemePreviews
@Composable
private fun SampleButtonPreview() {
    SampleButton(charSequence = "Sample button here") {}
}