package com.lynnkale.todoallthethings.edittodo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lynnkale.todoallthethings.R
import com.lynnkale.todoallthethings.core.ui.ErrorMessage
import com.lynnkale.todoallthethings.core.ui.ToDoDialog
import com.lynnkale.todoallthethings.core.ui.ToDoTextArea
import com.lynnkale.todoallthethings.core.ui.ToDoTextField
import com.lynnkale.todoallthethings.core.ui.theme.ToDoAllTheThingsTheme
import com.lynnkale.todoallthethings.core.ui.theme.defaultSpace
import com.lynnkale.todoallthethings.edittodo.viewmodel.EditTodoItemState
import com.lynnkale.todoallthethings.todolist.model.ToDoItem
import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity

@Composable
fun EditItemScreen(
    viewState: EditTodoItemState,
    onChangeName: (String) -> Unit,
    onChangeDescription: (String) -> Unit,
    onSave: () -> Unit,
) {
    ToDoDialog(
        title = stringResource(if (viewState.isNew) R.string.create_new_item else R.string.edit_item),
        content = {
            Column(
                verticalArrangement = Arrangement.spacedBy(space = defaultSpace),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (viewState.errors.isNotEmpty()) {
                    var message = "Please fix the following before saving:\n"
                    viewState.errors.values.forEach() { list ->
                        message += list.map { resourceId ->
                            stringResource(resourceId)
                        }.joinToString(separator = "\n")
                    }
                    ErrorMessage(messageText = message)
                }

                ToDoTextField(
                    label = stringResource(R.string.name_label),
                    value = viewState.item.name,
                    placeholder = stringResource(id = R.string.name_placeholder),
                    onValueChange = onChangeName,
                    isError = viewState.errors.keys.contains(ToDoItem.FIELD_NAME),
                )
                ToDoTextArea(
                    label = stringResource(R.string.description_label),
                    value = viewState.item.description ?: "",
                    placeholder = stringResource(R.string.description_placeholder),
                    onValueChange = onChangeDescription,
                    isError = viewState.errors.keys.contains(ToDoItem.FIELD_DESCRIPTION),
                )

                Button(
                    onClick = onSave,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        text = stringResource(R.string.save),
                        style = MaterialTheme.typography.bodyMedium
                    )
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
        EditItemScreen(
            viewState = EditTodoItemState(item = ToDoItemEntity.mock()),
            onChangeName = {},
            onChangeDescription = {},
            onSave = {})
    }
}

@Preview(
    name = "Dark Mode Modal"
)
@Composable
fun NewItemModalDarkPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = true) {
        EditItemScreen(
            viewState = EditTodoItemState(item = ToDoItemEntity.mock(), isNew = true),
            onChangeName = {},
            onChangeDescription = {},
            onSave = {})
    }
}

@Preview(
    name = "With Errors Modal"
)
@Composable
fun NewItemModalErrorPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = true) {
        EditItemScreen(
            viewState = EditTodoItemState(
                item = ToDoItemEntity.mock(),
                errors = mapOf(ToDoItem.FIELD_NAME to listOf<Int>(R.string.name_value_required))
            ),
            onChangeName = {},
            onChangeDescription = {},
            onSave = {})
    }
}
