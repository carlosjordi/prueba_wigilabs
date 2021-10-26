package com.carlosjordi.pruebawigilabs.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable
fun MoviePoster(
    moviePoster: String,
    height: Dp = 400.dp
) {
    Image(
        painter = rememberImagePainter(moviePoster),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
    )
}

@Composable
fun MovieTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth(),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun MovieDescription(
    description: String,
    isShortDescription: Boolean = true
) {
    Text(
        text = description,
        modifier = Modifier.padding(horizontal = 8.dp),
        fontSize = if (isShortDescription) TextUnit.Unspecified else 18.sp
    )
}