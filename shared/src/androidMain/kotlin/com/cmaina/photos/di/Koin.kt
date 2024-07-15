package com.cmaina.fotos.shared.di

import com.cmaina.photos.di.dataModule
import com.cmaina.photos.di.networkModule
import com.cmaina.photos.di.presentationModule
import com.cmaina.photos.di.repositoryModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initializeKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(networkModule, dataModule, repositoryModule, presentationModule)
}