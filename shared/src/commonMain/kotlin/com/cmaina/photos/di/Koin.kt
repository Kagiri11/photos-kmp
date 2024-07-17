package com.cmaina.photos.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(appModules())
}

fun initKoin() = initKoin(enableNetworkLogs = false) {}

fun appModules() = listOf(networkModule, repositoryModule, presentationModule, platformModule())