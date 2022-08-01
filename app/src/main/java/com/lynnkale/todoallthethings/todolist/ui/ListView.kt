package com.lynnkale.todoallthethings.todolist.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lynnkale.todoallthethings.R
import com.lynnkale.todoallthethings.ui.Title
import com.lynnkale.todoallthethings.ui.theme.ToDoAllTheThingsTheme
import com.lynnkale.todoallthethings.ui.theme.Typography
import com.lynnkale.todoallthethings.ui.theme.defaultSpace

@Composable
fun ToDoList(
    closeAction: () -> Unit,
    checkAction: (Boolean) -> Unit,
    clickAction: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(defaultSpace)
    ) {
        ToDoCard(
            title = "Task 1",
            bodyText = "this is great",
            closeAction = { },
            checkAction = { },
            clickAction = { }
        )
        ToDoCard(
            title = "Task 2",
            bodyText = "this is great",
            closeAction = { },
            checkAction = { },
            clickAction = { },
            checked = true,
        )
        ToDoCard(
            title = "Task 3",
            bodyText = "This is a longer body text that explains more details about the task",
            closeAction = { },
            checkAction = { },
            clickAction = { }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoCard(
    title: String,
    bodyText: String,
    closeAction: () -> Unit,
    checkAction: (Boolean) -> Unit,
    clickAction: () -> Unit,
    modifier: Modifier = Modifier,
    checked: Boolean = false,
) {
    Card(
        onClick = clickAction,
        modifier = modifier.background(
            color = MaterialTheme.colorScheme.surface,

            ),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(all = defaultSpace)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {

            Checkbox(
                checked = checked,
                onCheckedChange = checkAction,
               // modifier = Modifier.size(48.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Title(title, modifier = Modifier)
                Text(bodyText, style = Typography.bodyMedium)
            }

            Spacer(modifier = Modifier.weight(0.2f))

            Image(
                painter = painterResource(id = R.drawable.ic_baseline_close_24),
                contentDescription = "Remove Task",
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                modifier = Modifier
                    .size(48.dp)
                    .clickable(onClick = closeAction),
            )
        }
    }
}

@Preview(
    name = "Light Mode"
)
@Composable
private fun ToDoCardLightPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = false) {
        ToDoCard(
            title = "Title",
            bodyText = "This is a longer body text that explains more details about the task",
            closeAction = {},
            checkAction = {},
            clickAction = {},
        )
    }
}

@Preview(
    name = "Dark Mode"
)
@Composable
private fun ToDoCardDarkPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = true) {
        ToDoCard(
            title = "Title",
            bodyText = "This is a longer body text that explains more details about the task",
            closeAction = {},
            checkAction = {},
            clickAction = {},
        )
    }
}

@Preview(
    name = "Light Mode List"
)
@Composable
private fun ToDoListPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = false) {
        ToDoList({}, {}, {})
    }
}

@Preview(
    name = "Dark Mode List"
)
@Composable
fun ToDoListDarkPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = true) {
        ToDoList({}, {}, {})
    }
}
