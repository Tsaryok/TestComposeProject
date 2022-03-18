package com.example.testcomposeproject.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.testcomposeproject.R
import com.example.testcomposeproject.ui.theme.semiBoldTypography

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppBarScreen(
    modifier: Modifier = Modifier,
    title: String,
    isBackBtnVisible: Boolean,
    isBackgroundTransparent: Boolean,
    onBackClick: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = if (!isBackgroundTransparent) 42.dp else 0.dp)
        ) {
            content()
        }
        Box(
            modifier = Modifier
                .height(42.dp)
                .fillMaxWidth()
                .background(if (!isBackgroundTransparent) MaterialTheme.colors.primary else Color.Transparent),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    style = semiBoldTypography().subtitle1,
                )
            }
            if (isBackBtnVisible) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    IconButton(
                        onClick = { onBackClick() },
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(vertical = 11.dp, horizontal = 16.dp),
                            painter = painterResource(R.drawable.ic_left_chevron),
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }
}