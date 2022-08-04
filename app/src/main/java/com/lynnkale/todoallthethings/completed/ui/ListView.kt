package com.lynnkale.todoallthethings.completed.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lynnkale.todoallthethings.completed.viewmodel.CompletedListState
import com.lynnkale.todoallthethings.core.ui.Title
import com.lynnkale.todoallthethings.core.ui.theme.Typography
import com.lynnkale.todoallthethings.core.ui.theme.defaultSpace
import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity

@Composable
fun CompletedListView(
    state: CompletedListState
) {
    if (state.completedItems.isEmpty()) {
        NoItems()
    } else {
        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(defaultSpace)
        ) {
            items(items = state.completedItems, key = { it.id }) { toDoItem ->
                CompletedCard(
                    item = toDoItem,
                )
            }
        }
    }
}

@Composable
private fun NoItems() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(
            space = defaultSpace,
            Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(imageVector = Icons.Filled.Info, contentDescription = "")
        Text(text = "No Completed Tasks!", style = Typography.bodyLarge)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CompletedCard(
    item: ToDoItemEntity,
    modifier: Modifier = Modifier,
) {
    Card(
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
            Spacer(modifier = Modifier.width(48.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Title(item.name, modifier = Modifier)
                item.description?.let {
                    Text(item.description, style = Typography.bodyMedium)
                }
            }

            Spacer(modifier = Modifier.weight(0.2f))

            Spacer(modifier = Modifier.width(48.dp))
        }
    }
}
