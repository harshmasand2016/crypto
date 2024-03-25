package com.compose.projects.cryptoapp.presentation.coindetails.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CoinTag(tag: String) {
    Box(
        modifier = Modifier
            // Apply shadow here. This is the outer box that will only serve to cast the shadow.
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(topEnd = 16.dp, bottomStart = 16.dp),
                clip = false, // Ensure the shadow casts outside the Box,
            )
            .padding(1.dp) // Slightly separate the shadow from the border
    ) {
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    shape = RoundedCornerShape(topEnd = 16.dp, bottomStart = 16.dp)


                )
                .padding(10.dp)
        )
        {

            Text(
                text = tag,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center
            )

        }
    }
}

