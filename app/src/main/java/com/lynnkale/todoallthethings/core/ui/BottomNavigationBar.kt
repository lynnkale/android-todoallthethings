package com.lynnkale.todoallthethings.core.ui

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lynnkale.todoallthethings.core.navigation.Completed
import com.lynnkale.todoallthethings.core.navigation.Navigator
import com.lynnkale.todoallthethings.core.navigation.TodoList
import com.lynnkale.todoallthethings.core.ui.theme.ToDoAllTheThingsTheme

@Composable
fun BottomNavigationBar(
    navigator: Navigator
) {
    val tabs = listOf(
        TodoList,
        Completed,
    )
    BottomAppBar {
        tabs.forEach { item ->
            IconButton(onClick = { navigator.navigateTo(item) }) {
                Icon(imageVector = item.icon, contentDescription = item.name)
            }
        }
    }
}

@Preview(name = "Dark Theme")
@Composable
fun DarkPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = true) {
        BottomNavigationBar(Navigator())
    }
}

@Preview(name = "Light Theme")
@Composable
fun LightPreview() {
    ToDoAllTheThingsTheme(useDarkTheme = false) {
        BottomNavigationBar(Navigator())
    }
}
