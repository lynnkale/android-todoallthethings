package com.lynnkale.todoallthethings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lynnkale.todoallthethings.ui.TopBar
import com.lynnkale.todoallthethings.ui.theme.ToDoAllTheThingsTheme
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
        val currentScreen: ToDoListDestination by remember { mutableStateOf(List) }
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopBar()
            }
        ) { innerPadding ->
            NavHost(navController = navController, startDestination = List.route, modifier = Modifier.padding(innerPadding)) {
                composable(route = List.route) {
                    List.screen()
                }
            }
        }
    }
}
