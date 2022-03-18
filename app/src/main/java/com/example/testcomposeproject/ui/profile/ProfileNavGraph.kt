package com.example.testcomposeproject.ui.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testcomposeproject.ui.profile.authorization.AuthRoute
import com.example.testcomposeproject.ui.profile.authorization.AuthViewModel

@Composable
fun ProfileNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ProfileDestinations.PROFILE_ROUTE,
) {
    val navActions: ProfileNavigationActions = remember(navController) {
        ProfileNavigationActions(navController)
    }
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(ProfileDestinations.PROFILE_ROUTE) {
            ProfileRoute(
                navigateToAuth = navActions.navigateToAuth,
            )
        }
        composable(ProfileDestinations.AUTHORIZATION_ROUTE) {
            AuthRoute(
                backNavigate = { navController.popBackStack() }
            )
        }
    }
}