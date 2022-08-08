package com.lynnkale.todoallthethings.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lynnkale.todoallthethings.core.ui.theme.defaultSpace

@Composable
fun ToDoDialog(
    title: String,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(defaultSpace),
        verticalArrangement = Arrangement.spacedBy(space = defaultSpace, Alignment.Top)
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.secondary)
        )
        content()
    }
}
