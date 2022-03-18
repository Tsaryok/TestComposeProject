package com.example.testcomposeproject.ui.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcomposeproject.R
import com.example.testcomposeproject.ui.theme.*

@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    modifier: Modifier = Modifier,
    navigateToAuth: () -> Unit,
) {
    AppBarScreen(
        modifier = modifier,
        title = stringResource(id = R.string.profile_title),
        isBackBtnVisible = false,
        isBackgroundTransparent = !uiState.isAuthorized,
    ) {
        if (uiState.isAuthorized) {
            AuthorizedProfileScreen()
        } else {
            UnauthorizedProfileScreen(
                onSignInClick = navigateToAuth
            )
        }
    }
}

@Composable
private fun AuthorizedProfileScreen(
    modifier: Modifier = Modifier
) {

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun UnauthorizedProfileScreen(
    modifier: Modifier = Modifier,
    onSignInClick: () -> Unit,
) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.img_unauthorized_profile_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
        )
        Text(
            text = stringResource(id = R.string.unauthorized_profile_title),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .padding(16.dp),
            textAlign = TextAlign.Center,
            style = mediumTypography().h2
        )
        val context = LocalContext.current
        Surface(
            onClick = onSignInClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            shape = RoundedCornerShape(14.dp),
            color = MaterialTheme.colors.secondary,
            role = Role.Button,
        ) {
            Text(
                text = stringResource(id = R.string.unauthorized_profile_sign_in_action).uppercase(),
                modifier = Modifier.padding(vertical = 14.dp),
                textAlign = TextAlign.Center,
                style = mediumTypography().body1,
                color = MaterialTheme.colors.onSecondary,
            )
        }
        ListItem(
            modifier = Modifier.padding(top = 32.dp),
            title = "Инструкции",
        ) {
            Toast.makeText(context, "Clicked on Инструкции", Toast.LENGTH_SHORT).show()
        }
        ListItem(
            title = "Центр поддержки",
        ) {
            Toast.makeText(context, "Clicked on Центр поддержки", Toast.LENGTH_SHORT).show()
        }
        ListItem(
            title = "Связаться с нами",
        ) {
            Toast.makeText(context, "Clicked on Связаться с нами", Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(horizontal = 16.dp, vertical = 11.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = title, style = regularTypography().subtitle1)
        Spacer(modifier = Modifier.weight(0.01F))
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_right_chevron),
            contentDescription = null,
            tint = PrimaryBlack.copy(alpha = 0.3F),
        )
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    TestComposeProjectTheme {
        ProfileScreen(
            uiState = ProfileUiState(
                isAuthorized = false,
            ),
            navigateToAuth = {}
        )
    }
}