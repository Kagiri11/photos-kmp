package com.cmaina.photos

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.cmaina.photos.presentation.screens.MainScreen
import com.cmaina.photos.di.initKoin
import org.koin.core.Koin

lateinit var koin: Koin

fun main() {
    koin = initKoin().koin
    return application {
        Thread.currentThread().contextClassLoader = this.javaClass.classLoader
        Window(
            onCloseRequest = ::exitApplication,
            title = "Photos"
        ) {
            MainScreen()
        }
    }
}