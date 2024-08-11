package com.cmaina.photos.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(appModules())
    }

fun initKoin() = initKoin {}

fun appModules() =
    listOf(localModule, networkModule, repositoryModule, presentationModule, platformModule())