package com.compose.projects.cryptoapp.presentation.coindetails.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.editor.simplecomposetext.ui.theme.PaynearbyTheme

@Composable
fun CoinTag(tag: String) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = PaynearbyTheme.colors.brandSecondary,
                shape = RoundedCornerShape(topStart = 0.dp, topEnd = 16.dp, bottomStart = 16.dp, bottomEnd = 0.dp)
            )
            .padding(10.dp)
    ) {
        Text(
            text = tag,
            color = PaynearbyTheme.colors.brandSecondary,
            textAlign = TextAlign.Center
        )
    }
}