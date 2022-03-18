package com.example.testcomposeproject.ui.profile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileViewModel : ViewModel() {
    val uiState = MutableStateFlow(ProfileUiState(false))

}

data class ProfileUiState(
    val isAuthorized: Boolean,
)