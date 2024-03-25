package com.compose.projects.cryptoapp.presentation.coinlist.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.compose.projects.cryptoapp.presentation.AppBarComposable
import com.compose.projects.cryptoapp.presentation.Screen
import com.compose.projects.cryptoapp.presentation.coinlist.CoinListViewModel
import com.compose.projects.cryptoapp.ui.theme.CryptoAppTheme


@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    CryptoAppTheme {
        Scaffold(
            topBar = {
                AppBarComposable(
                    titleText = "Coin List",
                    titleNavigationIcon = Icons.AutoMirrored.Default.List
                ) {
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
                    LazyColumn {
                        items(state.coins) {
                            CoinListItem(coin = it) {
                                navController.navigate(Screen.CoinDetailsScreen.route + "/${it.id}")
                            }
                        }
                    }

                    if (state.error.isNotEmpty()) {
                        Text(
                            text = state.error,
                            color = MaterialTheme.colorScheme.error,
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
