package com.lynnkale.todoallthethings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lynnkale.todoallthethings.completed.ui.CompletedListView
import com.lynnkale.todoallthethings.completed.viewmodel.CompletedListViewModel
import com.lynnkale.todoallthethings.core.navigation.*
import com.lynnkale.todoallthethings.core.navigation.TodoList
import com.lynnkale.todoallthethings.core.ui.BottomNavigationBar
import com.lynnkale.todoallthethings.core.ui.TopBar
import com.lynnkale.todoallthethings.core.ui.theme.ToDoAllTheThingsTheme
import com.lynnkale.todoallthethings.core.ui.theme.defaultSpace
import com.lynnkale.todoallthethings.edittodo.event.EditTodoItemEvent
import com.lynnkale.todoallthethings.edittodo.ui.EditItemScreen
import com.lynnkale.todoallthethings.edittodo.viewmodel.EditToDoViewModel
import com.lynnkale.todoallthethings.edittodo.viewmodel.NewToDoViewModel
import com.lynnkale.todoallthethings.todolist.event.ToDoListEvent
import com.lynnkale.todoallthethings.todolist.ui.ToDoList
import com.lynnkale.todoallthethings.todolist.viewmodel.TodoListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAllTheThingsApp()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoAllTheThingsApp() {
    ToDoAllTheThingsTheme {
        val currentScreen: ToDoListDestination by remember { mutableStateOf(TodoList) }
        val navController = rememberNavController()
        val navigator = Navigator()

        LaunchedEffect("navigation") {
            navigator.sharedFlow.collect { destination ->
                navController.navigate(destination.route)
            }
        }
        Scaffold(
            topBar = {
                TopBar()
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { navController.navigate(New.route) }
                ) {
                    Icon(Icons.Filled.Add, "New ToDo Item")
                }
            },
            bottomBar = {
                BottomNavigationBar(navigator = navigator)
            }
        ) { innerPadding ->
            Surface(modifier = Modifier.padding(defaultSpace)) {
                NavHost(
                    navController = navController,
                    startDestination = currentScreen.route,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable(route = TodoList.route) {
                        val viewModel = hiltViewModel<TodoListViewModel>()
                        ToDoList(
                            items = viewModel.state.value.todoItems,
                            closeAction = { item ->
                                viewModel.eventListener(
                                    ToDoListEvent.OnDismissEvent(item)
                                )
                            },
                            checkAction = { item, checked ->
                                viewModel.eventListener(
                                    ToDoListEvent.OnCheckEvent(
                                        item,
                                        checked
                                    )
                                )
                            },
                            clickAction = { item ->
                                val taskId = item.id
                                navController.navigateSingleTopTo("${Edit.route}/$taskId")
                            },
                        )
                    }
                    composable(route = New.route) {
                        val viewModel = hiltViewModel<EditToDoViewModel>()
                        EditItemScreen(
                            viewState = viewModel.viewState.value,
                            onChangeName = { name ->
                                viewModel.eventListener(
                                    EditTodoItemEvent.OnChangeName(name)
                                )
                            },
                            onChangeDescription = { description ->
                                viewModel.eventListener(
                                    EditTodoItemEvent.OnChangeDescription(description)
                                )
                            }
                        ) {
                            viewModel.eventListener(
                                EditTodoItemEvent.OnSaveEvent { navigator.navigateTo(TodoList) }
                            )
                        }
                    }
                    composable(
                        route = Completed.route
                    ) {
                        val viewModel = hiltViewModel<CompletedListViewModel>()
                        CompletedListView(
                            state = viewModel.state.value
                        )
                    }
                    composable(
                        route = Edit.routeWithArgs,
                        arguments = Edit.arguments,
                    ) {
                        val viewModel = hiltViewModel<EditToDoViewModel>()
                        EditItemScreen(
                            viewState = viewModel.viewState.value,
                            onChangeName = { name ->
                                viewModel.eventListener(
                                    EditTodoItemEvent.OnChangeName(name)
                                )
                            },
                            onChangeDescription = { description ->
                                viewModel.eventListener(
                                    EditTodoItemEvent.OnChangeDescription(description)
                                )
                            },
                            onSave = {
                                viewModel.eventListener(
                                    EditTodoItemEvent.OnSaveEvent { navigator.navigateTo(TodoList) }
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}
