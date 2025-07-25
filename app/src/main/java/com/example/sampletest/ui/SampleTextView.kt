package com.example.sampletest.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * TextView for this app
 * This is a simple implementation of a composable textview
 * for this app
 * @param modifier [Modifier]
 * @param charSequence for annotated and plain text type
 * @param fontSize font size in it, internally will be converted
 * to [sp]
 * @param fontColor color for text
 * @param isBold if you want you font to be bold or not
 */
@Composable
fun SampleText(
    modifier: Modifier = Modifier,
    charSequence: CharSequence,
    fontSize: Int,
    fontColor: Color,
    isBold: Boolean = false
) {
    val textAnnotated = charSequence as? AnnotatedString
    val textString = charSequence as? String
    if (textString != null) {
        Text(
            modifier = modifier,
            text = textString,
            fontSize = fontSize.sp,
            color = fontColor,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal
        )
    } else if (textAnnotated != null) {
        Text(
            modifier = modifier,
            text = textAnnotated,
            fontSize = fontSize.sp,
            color = fontColor,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@CombineThemePreviews
@Composable
private fun SampleTextPreview() {
    SampleText(
        charSequence = "Sample text here",
        fontSize = 14,
        fontColor = Color.Cyan
    )
}