package com.cmaina.photos.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication {
    val appModules = listOf(
        presentationModule,
        repositoryModule,
        networkModule,
        localModule,
        platformModule())
    return startKoin {
        appDeclaration()
        modules(appModules)
    }
}

fun initKoin() = initKoin {}
