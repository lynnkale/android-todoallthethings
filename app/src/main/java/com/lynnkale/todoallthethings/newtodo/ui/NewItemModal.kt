package com.lynnkale.todoallthethings.newtodo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lynnkale.todoallthethings.ui.theme.ToDoAllTheThingsTheme
import com.lynnkale.todoallthethings.ui.theme.Typography
import com.lynnkale.todoallthethings.ui.theme.defaultSpace

@Composable
fun NewItemModal(
    onSave: () -> Unit,
) {

    Modal(
        title = "Create New Todo",
        content = {
            Column(verticalArrangement = Arrangement.spacedBy(space = defaultSpace)) {
                Text(
                    text = "Just click the button. Don't worry about the details",
                    style = MaterialTheme.typography.bodyMedium
                )
                Button(onClick = onSave, modifier = Modifier.align(Alignment.End)) {
                    Text(text = "Click me!", style = MaterialTheme.typography.bodyMedium)
                }
            }
        },
    )
}

@Composable
fun Modal(
    title: String,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(defaultSpace),
        verticalArrangement = Arrangement.spacedBy(space = defaultSpace, Alignment.Top)
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth(0.7f)
                .background(color = MaterialTheme.colorScheme.secondary)
        )
        content()
    }
}

@Preview(
    name = "Light Mode Modal"
)
@Composable
fun NewItemModalLightPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = false) {
        NewItemModal(onSave = {})
    }
}

@Preview(
    name = "Dark Mode Modal"
)
@Composable
fun NewItemModalDarkPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = true) {
        NewItemModal(onSave = {})
    }
}
