package com.example.testcomposeproject.ui.profile.authorization

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcomposeproject.R
import com.example.testcomposeproject.ui.profile.AppBarScreen
import com.example.testcomposeproject.ui.profile.CustomTextField
import com.example.testcomposeproject.ui.profile.ProfileScreen
import com.example.testcomposeproject.ui.profile.ProfileUiState
import com.example.testcomposeproject.ui.theme.*

@OptIn(ExperimentalMaterialApi::class, androidx.compose.ui.ExperimentalComposeUiApi::class)
@Composable
fun AuthScreen(
    uiState: AuthUiState,
    modifier: Modifier = Modifier,
    backNavigate: () -> Unit,
    onPhoneChange: (String) -> Unit,
    onGetCodeClick: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    AppBarScreen(
        modifier = modifier,
        title = stringResource(id = R.string.auth_title),
        isBackBtnVisible = true,
        isBackgroundTransparent = false,
        onBackClick = {
            keyboardController?.hide()
            backNavigate()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 12.dp)
        ) {
            Text(
                text = stringResource(id = R.string.auth_phone_number),
                style = regularTypography().subtitle1,
            )
            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                onPhoneChange = onPhoneChange,
                hint = stringResource(id = R.string.auth_enter_phone_number_hint),
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = stringResource(id = R.string.auth_enter_phone_number_description),
                style = regularTypography().caption,
            )
            LazyColumn(modifier = Modifier.weight(1F)) {}
            Surface(
                onClick = {
                    keyboardController?.hide()
                    onGetCodeClick()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                shape = RoundedCornerShape(14.dp),
                color = getButtonColor(uiState.getCodeBtnEnabled),
                enabled = uiState.getCodeBtnEnabled,
                role = Role.Button,
            ) {
                Text(
                    text = stringResource(id = R.string.auth_get_code_action).uppercase(),
                    modifier = Modifier.padding(vertical = 14.dp),
                    textAlign = TextAlign.Center,
                    style = mediumTypography().body1,
                    color = getButtonTextColor(uiState.getCodeBtnEnabled),
                )
            }
        }
    }
}

private fun getButtonColor(isEnabled: Boolean): Color {
    return if (isEnabled) PrimaryPinkBright else SecondarySystemGray
}

private fun getButtonTextColor(isEnabled: Boolean): Color {
    return if (isEnabled) Color.White else SecondaryGray
}

@Preview
@Composable
fun PreviewAuthScreen() {
    TestComposeProjectTheme {
        AuthScreen(
            uiState = AuthUiState(
                getCodeBtnEnabled = false,
            ),
            backNavigate = {},
            onPhoneChange = {},
            onGetCodeClick = {},
        )
    }
}
