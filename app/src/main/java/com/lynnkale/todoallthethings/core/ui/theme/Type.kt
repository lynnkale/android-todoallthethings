package com.lynnkale.todoallthethings.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.lynnkale.todoallthethings.R

// Set of Material typography styles to start with
val Typography = Typography(
    labelSmall = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.abel_regular)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.abel_regular)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.abel_regular)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.abel_regular)
        ),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.abel_regular)
        ),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.abel_regular)
        ),
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.mouse_memoirs_regular)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 1.5.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.mouse_memoirs_regular)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = 1.5.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.mouse_memoirs_regular)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        letterSpacing = 1.5.sp,
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
