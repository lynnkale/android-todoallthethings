package com.lynnkale.todoallthethings.core.ui

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = { Title(text = "To Do ALL THE THINGS!", modifier = Modifier) },
        modifier = modifier,
        navigationIcon = {},
        actions = {},
    )
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}
