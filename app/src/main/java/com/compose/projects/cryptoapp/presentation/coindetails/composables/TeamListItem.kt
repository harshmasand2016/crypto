package com.compose.projects.cryptoapp.presentation.coindetails.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.editor.crypto.data.remote.dto.TeamMember

@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        val annotatedText = buildAnnotatedString {
            // Append name with default styling
            append(teamMember.name + "~")

            // Append position in italics
            withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                append(teamMember.position)
            }
        }
        Text(text = annotatedText)
        Spacer(modifier = modifier.height(4.dp))
    }
}