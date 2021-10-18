package com.example.composelike

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun ComposelikeApp() {

    val simulationViewModel: SimulationViewModel = viewModel(
        factory = SimulationViewModelFactory()
    )

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "loadingScreen"
    ) {
        // TODO: An Options Screen
        // TODO: A Character Screen
        // TODO: A Stats Screen
        composable("loadingScreen") {
            LoadingScreen(simulationViewModel, navController)
        }
        composable("composelikeInterface") {
            ComposelikeInterface(simulationViewModel, navController)
        }
        composable("inventoryScreen") {
            InventoryScreen(simulationViewModel, navController)
        }
        composable("messageLog") {
            MessageLogScreen(simulationViewModel)
        }
        composable("mapScreen") {
            MapScreen(simulationViewModel)
        }
    }
}