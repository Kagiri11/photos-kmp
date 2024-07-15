package com.cmaina.photos.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initializeKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        com.cmaina.photos.di.networkModule,
        com.cmaina.photos.di.dataModule,
        com.cmaina.photos.di.repositoryModule,
        com.cmaina.photos.di.presentationModule
    )
}