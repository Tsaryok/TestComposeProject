package com.example.testcomposeproject.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.example.testcomposeproject.ui.profile.ProfileNavGraph
import com.example.testcomposeproject.ui.theme.TestComposeProjectTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ForBeautyApp() {
    TestComposeProjectTheme {
        ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setStatusBarColor(Color.Transparent, darkIcons = true)
                systemUiController.setNavigationBarColor(Color.White, darkIcons = true)
            }
            ProfileNavGraph()
        }
    }
}