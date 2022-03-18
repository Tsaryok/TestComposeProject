package com.example.testcomposeproject.ui.profile.authorization

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun AuthRoute(
    authViewModel: AuthViewModel = viewModel(),
    backNavigate: () -> Unit,
) {
    val uiState by authViewModel.uiState.collectAsState()

    AuthScreen(
        uiState = uiState,
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        backNavigate = backNavigate,
        onPhoneChange = { authViewModel.onPhoneChange(it) },
        onGetCodeClick = backNavigate,
    )
}