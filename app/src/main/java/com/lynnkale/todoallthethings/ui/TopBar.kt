package com.lynnkale.todoallthethings.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lynnkale.todoallthethings.ui.theme.defaultSpace

@Composable
fun TopBar() {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Title(text = "To Do ALL THE THINGS!", modifier = Modifier.padding(defaultSpace))
    }

}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}
