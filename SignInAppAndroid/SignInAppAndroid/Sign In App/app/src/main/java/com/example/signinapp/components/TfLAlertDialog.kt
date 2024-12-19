package com.example.signinapp.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

// TfLAlertDialog composable is a custom alert dialog
@Composable
fun TfLAlertDialog(
    title: String,
    message: String,
    dismissButtonText: String?,
    confirmButtonText: String,
    onDismissTapped: () -> Unit,
    onConfirmTapped: () -> Unit,
    testTag:String
) {

    AlertDialog(
        title = {
            Text(text = title)
        },
        modifier = Modifier.testTag(testTag),
        text = {
            Text(text = message)
        },
        dismissButton = {
            dismissButtonText?.let {
                Button(onClick = {
                    onDismissTapped()
                }) {
                    Text(text = it)
                }
            }
        },
        onDismissRequest = {
            onDismissTapped()
        },
        confirmButton = {
            Button(onClick = {
                onConfirmTapped()
            },
                modifier = Modifier.testTag("TechTaskConfirmButton")) {
                Text(text = confirmButtonText)
            }
        }
    )
}