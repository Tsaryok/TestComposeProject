package com.example.testcomposeproject.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
@Composable
fun regularTypography() = buildTypography(FontWeight.Normal)

@Composable
fun mediumTypography() = buildTypography(FontWeight.Medium)

@Composable
fun semiBoldTypography() = buildTypography(FontWeight.SemiBold)

@Composable
fun buildTypography(fontWeight: FontWeight): Typography {
    return Typography(
        defaultFontFamily = FontFamily.SansSerif,
        h1 = buildTextStyle(
            fontWeight = fontWeight,
            fontSize = 22.sp,
        ),
        h2 = buildTextStyle(
            fontWeight = fontWeight,
            fontSize = 20.sp
        ),
        subtitle1 = buildTextStyle(
            fontWeight = fontWeight,
            fontSize = 17.sp,
        ),
        body1 = buildTextStyle(
            fontWeight = fontWeight,
            fontSize = 15.sp
        ),
        caption = buildTextStyle(
            fontWeight = fontWeight,
            fontSize = 12.sp,
        ),
    )
}
@Composable
fun buildTextStyle(fontWeight: FontWeight, fontSize: TextUnit): TextStyle {
    val defaultColor = MaterialTheme.colors.onPrimary
    return TextStyle(
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = defaultColor,
    )
}