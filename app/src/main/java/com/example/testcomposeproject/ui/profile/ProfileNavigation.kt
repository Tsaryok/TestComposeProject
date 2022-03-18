package com.example.testcomposeproject.ui.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

object ProfileDestinations {
    const val PROFILE_ROUTE = "profile"
    const val MY_DATA_ROUTE = "my_data"
    const val MY_ADDRESS_ROUTE = "my_address"
    const val AUTHORIZATION_ROUTE = "authorization"
}

class ProfileNavigationActions(navController: NavController) {
    val navigateToProfile: () -> Unit = {
        navController.navigate(ProfileDestinations.PROFILE_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToAuth: () -> Unit = {
        navController.navigate(ProfileDestinations.AUTHORIZATION_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}