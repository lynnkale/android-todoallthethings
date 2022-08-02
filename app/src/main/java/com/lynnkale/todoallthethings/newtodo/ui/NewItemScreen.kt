package com.lynnkale.todoallthethings.newtodo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lynnkale.todoallthethings.List
import com.lynnkale.todoallthethings.core.ui.ToDoDialog
import com.lynnkale.todoallthethings.core.ui.theme.ToDoAllTheThingsTheme
import com.lynnkale.todoallthethings.core.ui.theme.defaultSpace

@Composable
fun NewItemScreen(
    onSave: () -> Unit,
) {
    ToDoDialog(
        title = "Create New Todo",
        content = {
            Column(verticalArrangement = Arrangement.spacedBy(space = defaultSpace)) {
                Text(
                    text = "Just click the button. Don't worry about the details",
                    style = MaterialTheme.typography.bodyMedium
                )
                Button(
                    onClick = onSave,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "Click me!", style = MaterialTheme.typography.bodyMedium)
                }
            }
        },
    )
}

@Preview(
    name = "Light Mode Modal"
)
@Composable
fun NewItemModalLightPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = false) {
        NewItemScreen(onSave = {})
    }
}

@Preview(
    name = "Dark Mode Modal"
)
@Composable
fun NewItemModalDarkPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = true) {
        NewItemScreen(onSave = {} )
    }
}
