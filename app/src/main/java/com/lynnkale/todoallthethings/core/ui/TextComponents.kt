package com.lynnkale.todoallthethings.core.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lynnkale.todoallthethings.core.ui.theme.Typography

@Composable
fun Title (text: String, modifier: Modifier = Modifier) {
    Text (
        text = text,
        modifier,
        style = Typography.headlineLarge,
    )
}

@Preview
@Composable
fun TitlePreview() {
    Title(text = "Sample Title")
}
