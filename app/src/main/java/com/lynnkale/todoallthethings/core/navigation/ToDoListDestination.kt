package com.lynnkale.todoallthethings.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

interface ToDoListDestination {
    val icon: ImageVector
    val name: String
    val route: String
}

object TodoList : ToDoListDestination {
    override val icon = Icons.Filled.List
    override val name: String = "To Do List"
    override val route = "active-list"
}

object New : ToDoListDestination {
    override val icon = Icons.Filled.Add
    override val name: String = "New Task"
    override val route = "add-item"
}

object Completed : ToDoListDestination {
    override val icon: ImageVector = Icons.Filled.Done
    override val name: String = "Completed Tasks"
    override val route: String = "completed-list"
}
