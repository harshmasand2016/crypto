package com.compose.projects.cryptoapp.presentation.coindetails.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.projects.cryptoapp.presentation.coindetails.CoinDetailsViewModel
import com.editor.simplecomposetext.AppBar
import com.editor.simplecomposetext.ui.theme.PaynearbyTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CoinDetailsScreen(
    viewModel: CoinDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    PaynearbyTheme {
        Scaffold(
            topBar = {
                AppBar("${state.coin?.name}", Icons.Default.Home) {
                    //Do Nothing
                }
            }
        ) {
            Surface(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    state.coin?.let { coin ->
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth(),
                            contentPadding = PaddingValues(10.dp)
                        ) {
                            item {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp, end = 16.dp),
                                    horizontalArrangement = Arrangement.SpaceAround,
                                    verticalAlignment = Alignment.CenterVertically

                                ) {
                                    Text(
                                        text = "${state.coin.name}(${state.coin.symbol})",
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier.weight(8f),
                                        fontSize = 20.sp,
                                        textDecoration = TextDecoration.Underline
                                    )

                                    Text(
                                        text = if (state.coin.isActive) "Active" else "Inactive",
                                        color = if (state.coin.isActive) Color.Green else Color.Red,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier.weight(2f)
                                    )
                                }

                                if (state.coin.description.isNotEmpty()) {
                                    Spacer(modifier = Modifier.height(16.dp))
                                }

                                Text(
                                    text = state.coin.description,
                                    overflow = TextOverflow.Ellipsis,
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                FlowRow(
                                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                                    verticalArrangement = Arrangement.spacedBy(10.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    coin.tags.forEach { tag ->
                                        CoinTag(tag = tag)
                                    }
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                if (coin.team.isNotEmpty()) {

                                    Text(
                                        text = "Team Members",
                                        overflow = TextOverflow.Ellipsis,
                                    )

                                    Spacer(modifier = Modifier.height(16.dp))
                                }
                            }

                            items(coin.team) { teamMember ->
                                TeamListItem(
                                    teamMember = teamMember,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                )
                            }
                        }
                    }

                    if (state.error.isNotEmpty()) {
                        Text(
                            text = state.error,
                            color = PaynearbyTheme.colors.error,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .align(Alignment.Center)
                        )
                    }

                    if (state.isLoading) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                }
            }
        }
    }

}