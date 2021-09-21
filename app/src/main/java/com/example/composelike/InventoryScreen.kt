package com.example.composelike

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun InventoryScreen(
    simulationViewModel: SimulationViewModel,
    navController: NavController,
) {

    val inventoryEntries by simulationViewModel.inventoryEntries.observeAsState()

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text("INVENTORY")
            Text("-~-~-~-~-")
            Spacer(Modifier.height(8.dp))
        }
        for (entry in inventoryEntries!!) {
            item {
                Text(entry.displayedName, Modifier.clickable {
                    // TODO: Verify this still works with the new sim model:
                    simulationViewModel.simulation()?.let {
                        //simulationViewModel.entry.effect(it)
                        simulationViewModel.advanceSimByItem(entry.effect)
                        navController.navigate("composelikeInterface")
                    }
                })
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}