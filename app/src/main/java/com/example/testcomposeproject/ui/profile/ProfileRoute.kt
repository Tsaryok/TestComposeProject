package com.example.testcomposeproject.ui.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun ProfileRoute(
    profileViewModel: ProfileViewModel = viewModel(),
    navigateToAuth: () -> Unit,
) {

    val uiState by profileViewModel.uiState.collectAsState()

    ProfileScreen(
        uiState = uiState,
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        navigateToAuth = navigateToAuth,
    )
}