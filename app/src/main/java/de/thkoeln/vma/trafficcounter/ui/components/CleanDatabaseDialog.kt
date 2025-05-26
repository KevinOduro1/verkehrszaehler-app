package de.thkoeln.vma.trafficcounter.ui.components
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CleanDatabaseDialog(
    showDialog: Boolean,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            confirmButton = {
                TextButton(onClick = onConfirmation) {
                    Text("Löschen")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismissRequest) {
                    Text("Abbrechen")
                }
            },
            title = { Text(dialogTitle) },
            text = { Text(dialogText) },
            icon = { Icon(imageVector = icon, contentDescription = null) }
        )
    }
}
