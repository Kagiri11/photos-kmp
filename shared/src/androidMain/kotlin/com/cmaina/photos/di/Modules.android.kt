package com.cmaina.photos.di

import com.cmaina.photos.createAndroidDataStore
import com.cmaina.photos.data.local.getDatabaseBuilder
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { createAndroidDataStore(context = get()) }
    single { getDatabaseBuilder(ctx = get()) }
}