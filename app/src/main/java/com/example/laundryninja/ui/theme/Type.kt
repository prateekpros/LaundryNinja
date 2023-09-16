package com.example.laundryninja.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.laundryninja.R

// Set of Material typography styles to start with

val kalam = FontFamily(Font(R.font.kalam_bold, FontWeight.Bold),
            Font(R.font.kalam_regular, FontWeight.Normal),
            Font(R.font.kalam_light, FontWeight.Light))


val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = kalam,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    displayLarge = TextStyle(
            fontFamily = kalam,
    fontWeight = FontWeight.Normal,
    fontSize = 36.sp

    ),

    displayMedium = TextStyle(
        fontFamily = kalam,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = kalam,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),


    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

