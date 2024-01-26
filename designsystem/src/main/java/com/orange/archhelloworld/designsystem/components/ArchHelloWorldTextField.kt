package com.orange.archhelloworld.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import com.orange.archhelloworld.designsystem.annotations.ThemePreviews
import com.orange.archhelloworld.designsystem.theme.ArchHelloWorldTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoTextField(
    value: MutableState<String>,
    onValueChange: (String) -> Unit,
    label: String,
    error: Boolean,
    keyboardActions: KeyboardActions,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
) {
    var isFocused by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged { isFocused = !isFocused },
        value = value.value,
        onValueChange = onValueChange,
        label = {
            if (isFocused) {
                Text(text = label, style = MaterialTheme.typography.labelMedium)
            } else {
                Text(text = label, style = MaterialTheme.typography.labelSmall)
            }
        },
        singleLine = true,
        textStyle = MaterialTheme.typography.labelMedium,
        isError = error,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        trailingIcon = {
            if (value.value.isNotEmpty()) {
                IconButton(onClick = { value.value = "" }) {
                    Icon(imageVector = Icons.Rounded.Cancel, contentDescription = null)
                }
            }
        }
    )
}

@ThemePreviews
@Composable
fun TodoTextFieldPreview() {
    val text = remember { mutableStateOf("Text") }
    ArchHelloWorldTheme {
        Surface {
            TodoTextField(
                value = text,
                onValueChange = {},
                label = "Label",
                error = false,
                keyboardActions = KeyboardActions { },
                keyboardOptions = KeyboardOptions()
            )
        }
    }
}