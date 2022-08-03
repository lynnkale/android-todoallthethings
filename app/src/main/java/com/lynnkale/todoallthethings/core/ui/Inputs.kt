package com.lynnkale.todoallthethings.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lynnkale.todoallthethings.core.ui.theme.ToDoAllTheThingsTheme
import com.lynnkale.todoallthethings.core.ui.theme.defaultSpace

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoTextField(
    label: String,
    value: String,
    placeholder: String = "",
    isError: Boolean = false,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(style = MaterialTheme.typography.labelMedium, text = label, modifier = Modifier.padding(bottom = 6.dp))
        },
        placeholder = {
            Text(style = MaterialTheme.typography.bodyLarge, text = placeholder)
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(0.8f),
        isError = isError,
        textStyle = MaterialTheme.typography.bodyLarge,
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoTextArea(
    label: String,
    value: String,
    placeholder: String = "",
    isError: Boolean = false,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(style = MaterialTheme.typography.labelMedium, text = label)
        },
        placeholder = {
            Text(style = MaterialTheme.typography.bodyLarge, text = placeholder)
        },
        singleLine = false,
        maxLines = 4,
        modifier = Modifier.fillMaxWidth(0.8f),
        isError = isError,
        textStyle = MaterialTheme.typography.bodyLarge,
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
    )
}

@Preview(name = "Dark Theme Inputs")
@Composable
fun InputDarkPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = true) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(defaultSpace),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ToDoTextField(
                label = "Plain Text Field",
                value = "",
                placeholder = "",
                onValueChange = {})
            ToDoTextField(
                label = "Text Field with Value",
                value = "This is the value",
                placeholder = "",
                onValueChange = {})
            ToDoTextField(
                label = "Text Field with Placeholder",
                value = "",
                placeholder = "Some Placeholder Text",
                onValueChange = {})
            ToDoTextField(
                label = "Text Field with Error",
                value = "",
                placeholder = "Some Placeholder Text",
                isError = true,
                onValueChange = {})
            ToDoTextArea(
                label = "Long text",
                value = "",
                placeholder = "Enter Really Long Text Here",
                onValueChange = {})
            ToDoTextArea(
                label = "Long text with value",
                value = "When Compose runs your composables for the first time during initial " +
                        "composition, it keeps track of the composables that you call to describe " +
                        "your UI in a Composition. Recomposition is when Compose re-executes the " +
                        "composables that may have changed in response to data changes and then " +
                        "updates the Composition to reflect any changes.",
                placeholder = "Enter Really Long Text Here",
                onValueChange = {})
            Text(text = "is this centered?")
        }
    }
}

@Preview(name = "Light Theme Inputs")
@Composable
fun InputLightPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = false) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(defaultSpace),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ToDoTextField(
                label = "Text",
                value = "",
                placeholder = "Enter Text Here",
                onValueChange = {})
            ToDoTextArea(
                label = "Long text",
                value = "",
                placeholder = "Enter Really Long Text Here",
                onValueChange = {})
        }
    }
}
