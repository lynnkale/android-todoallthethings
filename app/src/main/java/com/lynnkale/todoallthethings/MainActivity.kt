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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lynnkale.todoallthethings.core.navigation.Navigator
import com.lynnkale.todoallthethings.core.ui.TopBar
import com.lynnkale.todoallthethings.core.ui.theme.ToDoAllTheThingsTheme
import com.lynnkale.todoallthethings.core.ui.theme.defaultSpace
import com.lynnkale.todoallthethings.newtodo.event.EditTodoItemEvent
import com.lynnkale.todoallthethings.newtodo.ui.NewItemScreen
import com.lynnkale.todoallthethings.newtodo.viewmodel.NewToDoViewModel
import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

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
        val currentScreen: ToDoListDestination by remember { mutableStateOf(List) }
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
            }
        ) { innerPadding ->
            Surface(modifier = Modifier.padding(defaultSpace)) {
                NavHost(
                    navController = navController,
                    startDestination = currentScreen.route,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable(route = List.route) {
                        List.screen()
                    }
                    composable(route = New.route) {

                        val viewModel = hiltViewModel<NewToDoViewModel>()
                        NewItemScreen(
                            onSave = {
                                viewModel.eventListener(
                                    EditTodoItemEvent.OnSaveEvent(
                                        item = ToDoItemEntity(
                                            name = "New Item Name!",
                                            description = "Make sure to actually do this thing before it's too late!",
                                        )
                                    )
                                )
                                navigator.navigateTo(List)
                            }
                        )
                    }
                }
            }
        }
    }
}
