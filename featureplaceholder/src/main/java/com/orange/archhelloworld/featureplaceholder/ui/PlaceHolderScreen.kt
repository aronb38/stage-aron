package com.orange.archhelloworld.featureplaceholder.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.orange.archhelloworld.designsystem.annotations.ThemePreviews
import com.orange.archhelloworld.designsystem.components.ArchHelloWorldLoader
import com.orange.archhelloworld.designsystem.theme.ArchHelloWorldTheme

@Composable
fun PlaceHolderScreen(
    modifier: Modifier = Modifier,
    placeHolderViewModel: PlaceHolderViewModel = hiltViewModel()
) {

    val uiState by placeHolderViewModel.placeHolderUiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState) {
        placeHolderViewModel.onScreenDisplayed()
    }

    Surface(modifier.fillMaxSize()) {
        BoxWithConstraints(contentAlignment = Alignment.Center) {
            when (uiState) {
                is PlaceHolderUiState.Loading -> ArchHelloWorldLoader()
                is PlaceHolderUiState.Success -> Greeting((uiState as PlaceHolderUiState.Success).message)
            }
        }
    }
}

@Composable
fun Greeting(message: String) {
    Text(
        text = message, style = MaterialTheme.typography.headlineLarge
    )
}

@ThemePreviews
@Composable
fun DefaultPreview() {
    ArchHelloWorldTheme {
        Greeting("Android")
    }
}