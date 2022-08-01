package com.lynnkale.todoallthethings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lynnkale.todoallthethings.todolist.ui.ToDoList
import com.lynnkale.todoallthethings.ui.theme.ToDoAllTheThingsTheme
import com.lynnkale.todoallthethings.ui.theme.defaultSpace

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAllTheThingsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background,
                            modifier = Modifier.fillMaxSize(),
                ) {
                    ToDoList(
                        closeAction = { /*TODO*/ },
                        checkAction = {},
                        clickAction = { /*TODO*/ },
                        modifier = Modifier.padding(defaultSpace)
                    )
                }
            }
        }
    }
}
