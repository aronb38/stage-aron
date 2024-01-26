package com.orange.archhelloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.orange.archhelloworld.designsystem.theme.ArchHelloWorldTheme
import com.orange.archhelloworld.featureplaceholder.ui.PlaceHolderScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchHelloWorldTheme {
                PlaceHolderScreen()
            }

        }
    }
}