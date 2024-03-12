package com.compose.projects.cryptoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.projects.cryptoapp.presentation.Screen
import com.compose.projects.cryptoapp.presentation.coindetails.composables.CoinDetailsScreen
import com.compose.projects.cryptoapp.presentation.coinlist.composables.CoinListScreen
import com.editor.simplecomposetext.ui.theme.PaynearbyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaynearbyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(Screen.CoinListScreen.route) {
                            CoinListScreen(navController = navController)
                        }

                        composable(
                            Screen.CoinDetailsScreen.route + "/{coinID}"
                        )
                        {
                            CoinDetailsScreen()
                        }

                    }


                }
            }
        }
    }
}
