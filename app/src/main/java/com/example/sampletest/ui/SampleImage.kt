package com.example.sampletest.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.fallback

/**
 * Sample image which downloads bitmap from url for
 * this app
 * @param modifier [Modifier]
 * @param url url from which image needs to be downloaded
 * @param fallback fallback drawable res when image download fails
 */
@Composable
fun SampleImage(
    modifier: Modifier = Modifier,
    url: String,
    @DrawableRes fallback: Int
) {
    Image(
        modifier = modifier,
        painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data(url)
                .fallback(fallback)
                .build()
        ),
        contentDescription = ""
    )
}