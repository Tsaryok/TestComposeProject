package com.example.testcomposeproject.ui.profile.authorization

import androidx.lifecycle.ViewModel
import com.example.testcomposeproject.ui.utils.isPhoneNumber
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class AuthViewModel : ViewModel() {
    val uiState = MutableStateFlow(AuthUiState(false))

    fun onPhoneChange(phone: String) {
        uiState.update { it.copy(getCodeBtnEnabled = isPhoneNumber(phone)) }
    }
}

data class AuthUiState(
    val getCodeBtnEnabled: Boolean
)