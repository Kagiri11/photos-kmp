package com.cmaina.photos.di

import com.cmaina.photos.data.local.createDataStore
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { createDataStore() }
}