package com.cmaina.photos

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.cmaina.photos.presentation.screens.MainScreen
import com.cmaina.photos.di.initKoin
import org.jetbrains.compose.resources.stringResource
import org.koin.core.Koin
import photos.shared.generated.resources.Res
import photos.shared.generated.resources.app_name
import java.util.Locale

lateinit var koin: Koin

fun main() {
    koin = initKoin().koin
    return application {
        Thread.currentThread().contextClassLoader = this.javaClass.classLoader
        Window(
            onCloseRequest = ::exitApplication,
            title = stringResource(Res.string.app_name)
        ) {
            MainScreen()
        }
    }
}