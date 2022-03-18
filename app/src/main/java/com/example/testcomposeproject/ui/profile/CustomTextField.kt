package com.example.testcomposeproject.ui.profile

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.testcomposeproject.ui.theme.PrimaryBlack
import com.example.testcomposeproject.ui.theme.SecondaryGray
import com.example.testcomposeproject.ui.theme.SecondarySystemGray
import com.example.testcomposeproject.ui.theme.regularTypography

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    hint: String = "",
    onPhoneChange: (String) -> Unit,
) {
    var phone by remember { mutableStateOf("") }
    var hasFocus by remember { mutableStateOf(false) }

    Card(
        modifier = modifier,
        elevation = getElevation(hasFocus),
        shape = RoundedCornerShape(8.dp),
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    hasFocus = it.hasFocus
                },
            value = phone,
            onValueChange = {
                phone = it
                onPhoneChange(it)
            },
            label = if (!hasFocus) {
                { Hint(hintString = hint) }
            } else null,
            textStyle = regularTypography().body1,
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryBlack,
                cursorColor = PrimaryBlack,
                backgroundColor = getBackgroundColor(hasFocus),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
        )
    }
}

@Composable
private fun Hint(hintString: String) {
    Text(
        text = hintString,
        style = regularTypography().body1,
        color = SecondarySystemGray,
    )
}

private fun getBackgroundColor(hasFocus: Boolean): Color {
    return if (hasFocus) {
        Color.White
    } else {
        SecondaryGray.copy(alpha = 0.5F)
    }
}

private fun getElevation(hasFocus: Boolean): Dp {
    return if (hasFocus) {
        8.dp
    } else {
        0.dp
    }
}