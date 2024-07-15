package com.cmaina.photos.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initializeKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(networkModule, dataModule, repositoryModule, presentationModule)
}