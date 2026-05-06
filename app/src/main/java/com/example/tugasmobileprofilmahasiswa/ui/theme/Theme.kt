package com.example.tugasmobileprofilmahasiswa.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.tugasmobileprofilmahasiswa.ui.theme.Accent
import com.example.tugasmobileprofilmahasiswa.ui.theme.BackgroundLight
import com.example.tugasmobileprofilmahasiswa.ui.theme.CardBg
import com.example.tugasmobileprofilmahasiswa.ui.theme.Primary
import com.example.tugasmobileprofilmahasiswa.ui.theme.PrimaryDark
import com.example.tugasmobileprofilmahasiswa.ui.theme.TextPrimary

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = CardBg,
    secondary = Accent,
    background = BackgroundLight,
    surface = CardBg,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
)

@Composable
fun ProfilMahasiswaTheme(content: @Composable () -> Unit) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = PrimaryDark.toArgb()
            WindowCompat.getInsetsController(window, view)
                .isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}